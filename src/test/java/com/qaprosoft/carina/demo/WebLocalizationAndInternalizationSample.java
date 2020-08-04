/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
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
 */
package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import com.qaprosoft.carina.demo.gui.pages.localizationSample.Languages;
import com.qaprosoft.carina.demo.gui.pages.localizationSample.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebLocalizationAndInternalizationSample extends AbstractTest {

    private WebDriver driver;

    /*
        Setting two drivers for parallel tests
        in multiple browsers.
     */
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {

        if (browser.equalsIgnoreCase("firefox")) {
            DesiredCapabilities firefoxCaps = new FirefoxCapabilities().getCapability("homeFirefoxTest");
            firefoxCaps.setBrowserName("firefox");
            firefoxCaps.setVersion("79.0");
            driver = getDriver("Firefox", firefoxCaps);
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = getDriver();
        }

    }

    @Test(dataProvider = "DP1", threadPoolSize = 2)
    @MethodOwner(owner = "qpsdemo")
    public void openHomeInDifferentLanguagesTest(String lang, String message) {

        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened());

        String welcomeText = mainPage.initPage(Languages.valueOf(lang));

        Assert.assertEquals(welcomeText, message);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(parallel = true, name = "DP1")
    public static Object[][] dataprovider() {

        return new Object[][]{
                {"EN", "Welcome to Wikipedia,"},
                {"ES", "Bienvenidos a Wikipedia,"},
                {"FR", "Wikipédia"},
                {"PT", "Bem-vindos à Wikipédia"}};

    }
}