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

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.NewsPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.ReportContext;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Test proxy in different modes
 *
 * @author qpsdemo
 */
public class ProxySampleTest implements IAbstractTest {

    @BeforeClass
    public void beforeClass() {
        // disable setting proxy to the system params
        R.CONFIG.put("proxy_set_to_system", "false");
    }

    @Test(description = "Test 'MANUAL' proxy mode")
    @MethodOwner(owner = "qpsdemo")
    public void manualModeTest() {
        R.CONFIG.put("proxy_type", "MANUAL", true);

        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_HOST).isEmpty(),
                "'proxy_host' configuration parameter should be set.");
        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_PORT).isEmpty(),
                "'proxy_port' configuration parameter should be set.");

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(),
                Proxy.ProxyType.MANUAL,
                "Type of the Selenium Proxy should be 'MANUAL'.");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu()
                .openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test 'DIRECT' proxy mode")
    @MethodOwner(owner = "qpsdemo")
    public void directModeTest() {
        R.CONFIG.put("proxy_type", "DIRECT", true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(),
                Proxy.ProxyType.DIRECT,
                "Type of the Selenium Proxy should be 'DIRECT'.");

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test 'PAC' proxy mode (send local pac file)")
    @MethodOwner(owner = "qpsdemo")
    public void pacModeTest() throws FileNotFoundException {
        R.CONFIG.put("proxy_type", "PAC", true);
        R.CONFIG.put("proxy_pac_local", "true", true);

        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_HOST).isEmpty(),
                "'proxy_host' configuration parameter should be set.");
        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_PORT).isEmpty(),
                "'proxy_port' configuration parameter should be set.");

        // We create local pac file from manual proxy parameters
        String pacContent = String.format("function FindProxyForURL(url, host) {\n"
                        + "return \"PROXY %s:%s\";\n"
                        + "}",
                Configuration.get(Configuration.Parameter.PROXY_HOST),
                Configuration.get(Configuration.Parameter.PROXY_PORT));

        File file = new File(ReportContext.getArtifactsFolder() + "/test.pac");

        try (PrintWriter out = new PrintWriter(file)) {
            out.write(pacContent);
        }

        R.CONFIG.put("proxy_autoconfig_url", file.getAbsolutePath(), true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(),
                Proxy.ProxyType.PAC,
                "Type of the Selenium Proxy should be 'PAC'.");

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test 'AUTODETECT' proxy mode.")
    @MethodOwner(owner = "qpsdemo")
    public void autodetectModeTest() {
        R.CONFIG.put("proxy_type", "AUTODETECT", true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(),
                Proxy.ProxyType.AUTODETECT,
                "Type of the Selenium Proxy should be 'AUTODETECT'.");

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test 'SYSTEM' proxy mode.")
    @MethodOwner(owner = "qpsdemo")
    public void systemModeTest() {
        R.CONFIG.put("proxy_type", "SYSTEM", true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(),
                Proxy.ProxyType.SYSTEM,
                "Type of the Selenium Proxy should be 'SYSTEM'.");

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

}
