@Library('QPS-Pipeline')_
import com.qaprosoft.jenkins.pipeline.runner.maven.QARunner

echo "MEW_MEW_MEW"
// new com.qaprosoft.jenkins.pipeline.runner.maven.QARunner(this).onPush()

pipeline {
    agent any
    parameters {
        string(
                name: 'folderName',
                defaultValue:"",
                description: "Organization name to be register as Jenkins folder."
        )
        string(
                name: 'pipelineLibrary',
                defaultValue:"QPS-Pipeline",
                description: "Groovy JobDSL/Pipeline library, for example: https://github.com/qaprosoft/qps-pipeline/releases"
        )
        string(
                name: 'runnerClass',
                defaultValue:"com.qaprosoft.jenkins.pipeline.runner.maven.QARunner",
                description: ""
        )
    }
    stages {
        stage("build") {
            steps {
                script {
                    Organization(this).register()
                }
            }
        }
    }
}