package com.qaprosoft.jobs


@Grab('org.testng:testng:6.3.1')

import groovy.io.FileType;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

createJobs()

void createJobs() {
    def list = []

    def currentBuild = Thread.currentThread().executable
    def workspace = currentBuild.getEnvVars()["WORKSPACE"]
    println "JENKINS_HOME: ${JENKINS_HOME}"
    println "WORKSPACE: ${WORKSPACE}"

    def dir = new File(workspace, "src/test/resources/testng_suites")
    dir.eachFileRecurse (FileType.FILES) { file ->
        list << file
    }

    list.each {
        def currentSuiteItem = it
        if (currentSuiteItem.name.endsWith('.xml')) {
            def xmlFile = new Parser(new File(currentSuiteItem.path).absolutePath)
            xmlFile.setLoadClasses(false)

            List<XmlSuite> suiteXml = xmlFile.parseToList()
            XmlSuite currentSuite = suiteXml.get(0)

            if (currentSuite.toXml().contains("jenkinsJobCreation")) {
            
                def jobFolder = currentSuite.getParameter("jenkinsJobFolder").toString()
    			folder(jobFolder) {
        			displayName(jobFolder)
    			}
    			
                String suiteName = currentSuiteItem.path
                String suiteFrontRemoval = "testng_suites/"
                suiteName = suiteName.substring(suiteName.lastIndexOf(suiteFrontRemoval) + suiteFrontRemoval.length(), suiteName.indexOf(".xml"))

                println "\n" + currentSuiteItem.path
                println "\n" + suiteName
                println "\n" + currentSuite.toXml() + "\n"
                println "jenkinsJobCreation: " + currentSuite.getParameter("jenkinsJobCreation").toString()
                if (currentSuite.getParameter("jenkinsJobCreation").contains("true")) {
                    def jobName = currentSuite.getParameter("jenkinsJobName").toString()
                    createViews(suiteName, jobFolder)
                    Job.createPipeline(pipelineJob(jobFolder + "/" + jobName), currentSuite, suiteName)
                }
            }
        }
    }
}

void createViews(suiteName, jobFolder) {
    String[] viewCreationList = suiteName.tokenize("\\")
    println "\n Checking View List: ${viewCreationList}"

    if (viewCreationList.size() >= 2) {
        for (int i = 0; i < 2; i++) {
            println viewCreationList[i].capitalize()
            listView(jobFolder + "/" + viewCreationList[i].toUpperCase()) {
                columns {
                    status()
                    weather()
                    name()
                    lastSuccess()
                    lastFailure()
                    lastDuration()
                    buildButton()
                }
                jobs {
                    def filterString = String.format("(?i).*%s.*", viewCreationList[i]).capitalize()
                    regex("${filterString}")
                }
            }
        }
    }
}

class Job {

    static void createPipeline(pipelineJob, org.testng.xml.XmlSuite currentSuite, String suiteName) {
        pipelineJob.with {
            description(currentSuite.name)
            logRotator {
                numToKeep 100
            }

            /** Properties & Parameters Area **/
            parameters {
                choiceParam('env', getEnvironments(currentSuite), 'Environment to test against.')

                switch(suiteName) {
                    case ~/^.*android.*$/:
                        choiceParam('device', getDeviceList(suiteName), "Select the Device a Test will run against.  ALL - Any available device, PHONE - Any available phone, TABLET - Any tablet")
                        stringParam('build', '.*', "latest - use fresh build artifact from S3 or local storage;")
                        booleanParam('recoveryMode', true, 'Restart application between retries')
                        booleanParam('auto_screenshot', false, 'Generate screenshots automatically during the test')
                        booleanParam('keep_all_screenshots', false, 'Keep screenshots even if the tests pass')
                        configure addHiddenParameter('browser', '', 'NULL')
                        break;
                    default:
                        booleanParam('auto_screenshot', false, 'Generate screenshots automatically during the test')
                        booleanParam('keep_all_screenshots', false, 'Keep screenshots even if the tests pass')
                        configure addHiddenParameter('browser', '', 'NULL')
                        break;
                }

                configure addExtensibleChoice('repository', "gc_GIT_REPOSITORY", "Select a GitHub Testing Repository to run against", "git@github.com:qaprosoft/carina-demo.git")
                configure addExtensibleChoice('branch', "gc_GIT_BRANCH", "Select a GitHub Testing Repository Branch to run against", "master")
                configure addHiddenParameter('suite', '', suiteName)
                configure addHiddenParameter('ci_parent_url', '', '')
                configure addHiddenParameter('ci_parent_build', '', '')

                stringParam('email_list', currentSuite.getParameter("jenkinsEmail").toString(), 'List of Users to be emailed after the test')
                choiceParam('retry_count', [1, 2, 3, 0], 'Number of Times to Retry a Failed Test')
                booleanParam('develop', false, 'Check to execute test without registration to Zafira and TestRail')
                booleanParam('rerun_failures', false, 'During \"Rebuild\" pick it to execute only failed cases')
                configure addHiddenParameter('project', '', "SING")
                configure addHiddenParameter('overrideFields', '' , getCustomFields(currentSuite))
            }

            /** Git Stuff **/
            definition {
                cpsScm {
                    scm {
                        git {
                            remote {
                                url('${repository}')
                                credentials('qJenkins-Token')
                            }
                            branch('${branch}')
                        }
                    }
                    scriptPath('src/main/groovy/com/qaprosoft/pipelines/JenkinsFile')
                }
            }
        }
    }

    static Closure addExtensibleChoice(choiceName, globalName, desc, choice) {
        //TODO:  Need to move the choiceListProvider into a parameterized class as well as that can change.
        return { node ->
            node / 'properties' / 'hudson.model.ParametersDefinitionProperty' / 'parameterDefinitions' << 'jp.ikedam.jenkins.plugins.extensible__choice__parameter.ExtensibleChoiceParameterDefinition'(plugin: 'extensible-choice-parameter@1.3.3') {
                name choiceName
                description desc
                editable false
                choiceListProvider(class: 'jp.ikedam.jenkins.plugins.extensible_choice_parameter.GlobalTextareaChoiceListProvider') {
                    whenToAdd 'Triggered'
                    name globalName
                    defaultChoice choice
                }
            }
        }
    }

    static Closure addHiddenParameter(paramName, paramDesc, paramValue) {
        return { node ->
            node / 'properties' / 'hudson.model.ParametersDefinitionProperty' / 'parameterDefinitions' << 'com.wangyin.parameter.WHideParameterDefinition'(plugin: 'hidden-parameter@0.0.4') {
                name paramName
                description paramDesc
                defaultValue paramValue
            }
        }
    }

    static void createRegressionPipeline(pipelineJob, suiteName, List customFields) {
        pipelineJob.with {
            description(suiteName)
            logRotator {
                numToKeep 100
            }
            configure addExtensibleChoice('repository', "repositories", "Select a GitHub Testing Repository to run against", "git@github.com:qaprosoft/carina-demo.git")
            configure addExtensibleChoice('branch', "gc_GIT_BRANCH", "Select a GitHub Testing Repository Branch to run against", "master")
            parameters {
                stringParam('email_list_for_pipeline', 'msarychau@qaprosoft.com', 'List of Users to be emailed after the test')
                booleanParam('overrideEmail', false, 'Check to override email field on all Pipeline Jobs with above email')
                for (String customField : customFields) {
                    if (!customField.contains("=")) {
                        stringParam(customField, "", "Custom Field")
                    } else {
                        def customFieldList = customField.split("=")
                        stringParam(customFieldList[0], customFieldList[1].toString(), "Custom Field")
                    }
                }
            }
            configure addHiddenParameter('overrideFields', 'This allows for mass overriding of any fields in this pipeline.', '')
            definition {
                cpsScm {
                    scm {
                        git {
                            remote {
                                url('${repository}')
                                credentials('qJenkins-Token')
                            }
                            branch('${branch}')
                        }
                    }
                    scriptPath('src/main/groovy/com/qaprosoft/pipelines/JenkinsFilePipeline')
                }
            }
        }
    }

    static List<String> getEnvironments(currentSuite) {
        def envList = getGenericSplit(currentSuite, "jenkinsEnvironments")

        if (envList.isEmpty()) {
            envList.add("QA")
        }

        return envList
    }

    static String getCustomFields(currentSuite) {
        def overrideFields = getGenericSplit(currentSuite, "overrideFields")
        def prepCustomFields = ""

        if (!overrideFields.isEmpty()) {
            for (String customField : overrideFields) {
                prepCustomFields = prepCustomFields + " -D" + customField
            }
        }

        return prepCustomFields
    }

    static List<String> getGenericSplit(currentSuite, parameterName) {
        String genericField = currentSuite.getParameter(parameterName)
        def genericFields = []

        if (genericField != null) {
            if (!genericField.contains(", ")) {
                genericFields = genericField.split(",")
            } else {
                genericFields = genericField.split(", ")
            }
        }
        return genericFields
    }

    static List<String> getTagList(String tags) {
        if (tags.contains(", ")) {
            return tags.split(", ")
        } else {
            return tags.split(",")
        }
    }

    static List<String> getDeviceList(String suite) {
        def currentBuild = Thread.currentThread().executable
        def workspace = currentBuild.getEnvVars()["WORKSPACE"]
        def deviceList = ["ALL", "Samsung_Galaxy_TAB4_10", "Samsung_Galaxy_Note_4", "Samsung_Grand_Prime", "Samsung_Galaxy_S6", "Samsung_Galaxy_S7", "Motorola_Nexus_6"]

        return deviceList
    }

    static checkAndAddDevice(List<String> deviceList, String suite, Map deviceEntry) {

        switch(suite.toLowerCase()) {
            case ~/^.*handset.*$/:
                deviceList.add(deviceEntry.get("device").toString())
                checkAndAddDeviceType(deviceList, deviceEntry)
                deviceList.sort { a,b -> a.toLowerCase() <=> b.toLowerCase() }
                deviceList.remove("phone")
                deviceList.add(0,"phone")
            case ~/^.*tablet.*$/:
                if (deviceEntry.get("deviceType").toString().toLowerCase().contains("tablet") && !deviceList.contains(deviceEntry.get("device"))) {
                    deviceList.add(deviceEntry.get("device").toString())
                    checkAndAddDeviceType(deviceList, deviceEntry)
                    deviceList.sort { a,b -> a.toLowerCase() <=> b.toLowerCase()  }
                    deviceList.remove("tablet")
                    deviceList.add(0,"tablet")
                }
                break;
            default:
                deviceList.add(deviceEntry.get("device").toString())
                checkAndAddDeviceType(deviceList, deviceEntry)
                deviceList.sort { a,b -> a.toLowerCase() <=> b.toLowerCase()  }
                break;
        }
    }

    static checkAndAddDeviceType(List<String> deviceList, Map deviceEntry) {
        if (!deviceList.contains(deviceEntry.get("deviceType").toString().toLowerCase())) {
            deviceList.add(deviceEntry.get("deviceType").toString())
        }
        checkAndAddTag(deviceList, deviceEntry)

        return deviceList
    }

    static checkAndAddTag(List<String> deviceList, Map deviceEntry) {
        if (deviceEntry.get("tags") != null) {
            for (String tag : getTagList(deviceEntry.get("tags").toString())) {
                if (!deviceList.contains(tag.toLowerCase())) {
                    deviceList.add(tag)
                }
            }
        }
        return deviceList
    }
}