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

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.demo.gui.components.NewsItem;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.FirefoxCapabilities;

/**
 * This sample shows how initialize multiple drivers and run the tests on different browsers.
 *
 * @author qpsdemo
 */
public class WebMultipleBrowserTest implements IAbstractTest {
    private static final String CHROME_DRIVER_NAME = "chrome";
    private static final String FIREFOX_DRIVER_NAME = "firefox";

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void multipleBrowserTest() {
        HomePageBase chromeHomePage = initPage(getDriver(CHROME_DRIVER_NAME,
                new ChromeCapabilities().getCapability("Chrome Test")), HomePageBase.class);
        chromeHomePage.open();
        Assert.assertTrue(chromeHomePage.isPageOpened(), "Chrome home page is not opened!");

        HomePageBase firefoxHomePage = initPage(getDriver(FIREFOX_DRIVER_NAME,
                new FirefoxCapabilities().getCapability("Firefox Test")), HomePageBase.class);
        firefoxHomePage.open();
        Assert.assertTrue(firefoxHomePage.isPageOpened(), "Firefox home page is not opened!");

        final String searchQ = "iphone";
        SoftAssert softAssert = new SoftAssert();

        NewsPageBase chromeNewsPage = chromeHomePage.getFooterMenu().openNewsPage();
        List<NewsItem> chromeNews = chromeNewsPage.searchNews(searchQ);
        Screenshot.capture(getDriver(CHROME_DRIVER_NAME), ScreenshotType.EXPLICIT_VISIBLE, "Chrome capture!");
        softAssert.assertFalse(CollectionUtils.isEmpty(chromeNews), "News not found!");
        for (NewsItem n : chromeNews) {
            System.out.println(n.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ), "Invalid search results for chrome!");
        }

        NewsPageBase firefoxNewsPage = firefoxHomePage.getFooterMenu().openNewsPage();
        List<NewsItem> firefoxNews = firefoxNewsPage.searchNews(searchQ);
        Screenshot.capture(getDriver(FIREFOX_DRIVER_NAME), ScreenshotType.EXPLICIT_VISIBLE, "Firefox capture!");
        softAssert.assertFalse(CollectionUtils.isEmpty(firefoxNews), "News not found!");
        for (NewsItem n : firefoxNews) {
            System.out.println(n.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ), "Invalid search results for firefox!");
        }

        softAssert.assertAll();
    }
}
