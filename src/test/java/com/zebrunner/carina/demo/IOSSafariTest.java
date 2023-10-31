/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo;

import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.gui.pages.ios.SaucePage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class IOSSafariTest implements IAbstractTest, IMobileUtils {

    @BeforeSuite
    public void beforeSuite() {
        WebDriverConfiguration.addIgnoredNewSessionErrorMessages("timed out waiting for a node to become available", "TimeoutException");
    }

    @Test(invocationCount = 200, threadPoolSize = 100)
    public void safariTest() {
        SaucePage saucePage = new SaucePage(getDriver());
        saucePage.openURL("http://saucelabs.com/test/guinea-pig");
        
        saucePage.verifyElementText();
        saucePage.sendComment();
    }

}
