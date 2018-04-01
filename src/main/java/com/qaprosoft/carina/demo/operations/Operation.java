package com.qaprosoft.carina.demo.operations;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.performance.Timer;
import org.openqa.selenium.WebDriver;

public class Operation {

    private InitialPage page;

    public Operation(WebDriver driver) {
        page = new InitialPage(driver);
        page.open();
    }


    public enum Operations implements Timer.IPerformanceOperation {

        LOGIN("login"), LOGOUT("logout"), SUBMIT("submit"), SEARCH("search"),
        PASSWORD("password"), SINGIN("sing in");

        private String key;

        private Operations(String key) {
            this.key = key;
        }

        @Override
        public String getKey() {
            return this.key;
        }


    }

    public void loginOperation() {
        Timer.start(Operations.LOGIN);
        page.login();
        Timer.stop(Operations.LOGIN);
    }

    public void passwordOperation() {
        Timer.start(Operations.PASSWORD);
        page.enterPassword();
        Timer.stop(Operations.PASSWORD);

    }

    public void searchOperation() {

        Timer.start(Operations.SEARCH);
        page.search();
        Timer.stop(Operations.SEARCH);
    }
}
