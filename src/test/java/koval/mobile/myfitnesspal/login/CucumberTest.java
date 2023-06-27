package koval.mobile.myfitnesspal.login;


import io.cucumber.junit.CucumberOptions;


@CucumberOptions(features = "src/test/resources/koval_features/login.feature",
        glue = "com.zebrunner.carina.demo.cucumber.steps",
        plugin = {"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
)
public class CucumberTest{}