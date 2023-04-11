/*******************************************************************************
 * Copyright 2020-2022 Zebrunner Inc (https://www.zebrunner.com).
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

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.NewsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.proxy.browserup.ProxyPool;
import com.zebrunner.carina.utils.R;

/**
 * This sample shows how generate har file with proxied Web test content.
 *
 * @author qpsdemo
 */
public class LegacyProxySampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    BrowserUpProxy proxy;

    @BeforeMethod(alwaysRun = true)
    public void startProxy()
    {
        R.CONFIG.put("browserup_proxy", "true");
        getDriver();
        proxy = ProxyPool.getProxy();
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testNewsSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");

        // Saving har to a file...
        String name = "ProxyReport.har";
        File file = new File(name);
        Assert.assertNotNull(proxy.getHar(), "Har is NULL!");

        try {
            proxy.getHar().writeTo(file);
            Artifact.attachToTest(name, file);
        } catch (IOException e) {
            LOGGER.error("Unable to generate har archive!", e);
        }
    }

}
