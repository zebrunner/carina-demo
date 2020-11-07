package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberBaseTest;

import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = "src/test/resources/features/GSMArenaNews.feature",
@CucumberOptions(features = "src/test/resources/features/GSMArenaNews3.feature",
//@CucumberOptions(features = "src/test/resources/features/",
		glue = "com.qaprosoft.carina.demo.cucumber.steps",
        plugin = {"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
        //,plugin = "json:target/cucumber1.json"
)
public class CucumberWebSampleTest extends CucumberBaseTest {
    //do nothing here as everything is declared in "GSMArenaNews.feature" and steps

}
