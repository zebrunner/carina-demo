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
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * This sample shows how initialize multiple drivers and run the tests on different browsers.
 *
 * @author qpsdemo
 */
public class WebMultipleBrowserTest extends AbstractTest {

    WebDriver firefoxDriver = null;
    DesiredCapabilities ffCaps = new FirefoxCapabilities().getCapability("Firefox Test");
    String ffHost = "http://localhost:4444/wd/hub";

    WebDriver chromeDriver = null;
    DesiredCapabilities chromeCaps = new ChromeCapabilities().getCapability("Chrome Test");
    String chromeHost = "http://localhost:4545/wd/hub";

    @BeforeSuite
    public void initializeDrivers() {
        firefoxDriver = getDriver("firefox", ffCaps, ffHost);
        chromeDriver = getDriver("chrome", chromeCaps, chromeHost);
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void chromeBrowserTest() {
        HomePage chromeHomePage = new HomePage(chromeDriver);
        chromeHomePage.open();
        Assert.assertTrue(chromeHomePage.isPageOpened(), "Chrome home page is not opened!");

        NewsPage newsPage = chromeHomePage.getFooterMenu().openNewsPage();

        final String searchQ = "iphone";
        List<NewsItem> news = newsPage.searchNews(searchQ);

        Screenshot.capture(chromeDriver,"News page capture!");

        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");

        for(NewsItem n : news) {
            System.out.println(n.readTitle());
            Assert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ), "Invalid search results!");
        }

    }

    @Test(dataProvider = "DP1")
    @MethodOwner(owner = "qpsdemo")
    public void firefoxBrowserTest(String brand, String model, String ram) {
        HomePage firefoxHomePage = new HomePage(firefoxDriver);
        firefoxHomePage.open();
        Assert.assertTrue(firefoxHomePage.isPageOpened(), "Firefox home page is not opened!");

        BrandModelsPage brandPage = firefoxHomePage.selectBrand(brand);

        ModelInfoPage modelInfoPage = brandPage.selectModel(model);

        Screenshot.capture(firefoxDriver,"News page capture!");

        Assert.assertEquals(modelInfoPage.readRam(), ram);
    }

    @DataProvider(name = "DP1")
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"Xiaomi", "Poco C3", "3/4GB RAM"},
                {"Samsung", "Galaxy M51", "6/8GB RAM"},
                {"Asus", "Zenfone 6 ZS630KL", "6/8GB RAM"}
        };
    }

    @AfterSuite
    public void tearDown() {
        firefoxDriver.quit();
        chromeDriver.quit();
    }
}
