/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
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

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.proxy.CustomProxy;
import com.qaprosoft.carina.demo.proxy.CustomProxyRule;
import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.proxy.ProxyPool;
import com.zebrunner.carina.proxy.browserup.CarinaBrowserUpProxy;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.ReportContext;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;

/**
 * This sample shows how generate har file with proxied Web test content.
 *
 * @author qpsdemo
 */
public class ProxySampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeClass
    public void beforeClass() {
        R.CONFIG.put("proxy_set_to_system", "false");
    }

    @Test(description = "Test proxy, setted manually (from configuration proxy_host, proxy_port etc)")
    @MethodOwner(owner = "qpsdemo")
    public void manualProxyTest() {
        R.CONFIG.put("proxy_type", "MANUAL", true);
        R.CONFIG.put("proxy_protocols", "http,https", true);

        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_HOST).isEmpty(),
                "Proxy host should be set in configuration to check manual proxy.");
        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_PORT).isEmpty(),
                "Proxy port should be set in configuration to check manual proxy.");
        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(), Proxy.ProxyType.MANUAL,
                "Proxy type in capabilities should be MANUAL.");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test direct proxy mode (without proxy)")
    @MethodOwner(owner = "qpsdemo")
    public void directProxyTest() {
        R.CONFIG.put("proxy_type", "DIRECT", true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(), Proxy.ProxyType.DIRECT,
                "Proxy type in capabilities should be DIRECT.");

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test pac proxy. Pac file created from manually setted proxy_host, proxy_port configuration.")
    @MethodOwner(owner = "qpsdemo")
    public void pacProxyTest() throws FileNotFoundException {
        R.CONFIG.put("proxy_type", "PAC", true);
        R.CONFIG.put("proxy_pac_local", "true", true);

        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_HOST).isEmpty(),
                "Proxy host should be set in configuration to check pac proxy.");
        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_PORT).isEmpty(),
                "Proxy port should be set in configuration to check pac proxy.");

        String pacContent = String.format("function FindProxyForURL(url, host) {\n"
                + "return \"PROXY %s:%s\";\n"
                + "}", Configuration.get(Configuration.Parameter.PROXY_HOST), Configuration.get(Configuration.Parameter.PROXY_PORT));
        File file = new File(ReportContext.getArtifactsFolder() + "/test.pac");
        PrintWriter out = new PrintWriter(file);
        out.write(pacContent);
        out.close();
        R.CONFIG.put("proxy_autoconfig_url", file.getAbsolutePath(), true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(), Proxy.ProxyType.PAC,
                "Proxy type in capabilities should be PAC.");

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test autodetect proxy mode.")
    @MethodOwner(owner = "qpsdemo")
    public void autodetectProxyTest() {
        R.CONFIG.put("proxy_type", "AUTODETECT", true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(), Proxy.ProxyType.AUTODETECT,
                "Proxy type in capabilities should be AUTODETECT.");

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test system proxy mode.")
    @MethodOwner(owner = "qpsdemo")
    public void systemProxyTest() {
        R.CONFIG.put("proxy_type", "SYSTEM", true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(), Proxy.ProxyType.SYSTEM,
                "Proxy type in capabilities should be SYSTEM.");

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test unspecified proxy mode.")
    @MethodOwner(owner = "qpsdemo")
    public void unspecifiedProxyTest() {
        R.CONFIG.put("proxy_type", "UNSPECIFIED", true);

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(), Proxy.ProxyType.UNSPECIFIED,
                "Proxy type in capabilities should be UNSPECIFIED.");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Test(description = "Test default dynamic proxy (CarinaBrowserUpProxy)")
    @MethodOwner(owner = "qpsdemo")
    public void dynamicProxyTest() {
        R.CONFIG.put("browserup_proxy", "true", true);
        R.CONFIG.put("proxy_type", "DYNAMIC", true);
        R.CONFIG.put("proxy_port", "0", true);
        getDriver();
        BrowserUpProxy browserUpProxy = ProxyPool.getOriginal(CarinaBrowserUpProxy.class)
                .orElseThrow()
                .getProxy();
        browserUpProxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        browserUpProxy.newHar();

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(), Proxy.ProxyType.MANUAL,
                "Proxy type in capabilities should be DIRECT.");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");

        BrowserUpProxy proxy = ProxyPool.getOriginal(CarinaBrowserUpProxy.class)
                .orElseThrow()
                .getProxy();
        // Saving har to a file...
        String name = "ProxyReport.har";
        File file = new File(ReportContext.getArtifactsFolder() + "/" + name);
        Assert.assertNotNull(proxy.getHar(), "Har is NULL!");

        try {
            proxy.getHar().writeTo(file);
            Artifact.attachToTest(name, file);
        } catch (IOException e) {
            LOGGER.error("Unable to generate har archive!", e);
        }
    }

    @Test(description = "Test custom dynamic proxy with chained proxy (CustomProxy)")
    @MethodOwner(owner = "qpsdemo")
    public void customDynamicProxyTest() {
        R.CONFIG.put("browserup_proxy", "true", true);
        R.CONFIG.put("proxy_type", "DYNAMIC", true);
        R.CONFIG.put("proxy_port", "0", true);

        Assert.assertFalse(R.CONFIG.get("proxy_chain_host").isEmpty(),
                "proxy_chain_host should be set in configuration to check custom dynamic proxy.");
        Assert.assertFalse(Configuration.get(Configuration.Parameter.PROXY_PORT).isEmpty(),
                "proxy_chain_port should be set in configuration to check custom dynamic proxy.");

        ProxyPool.setRule(new CustomProxyRule(), true);

        getDriver();
        BrowserUpProxy browserUpProxy = ProxyPool.getOriginal(CustomProxy.class)
                .orElseThrow()
                .getProxy();
        browserUpProxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        browserUpProxy.newHar();

        Capabilities capabilities = ((HasCapabilities) getDriver()).getCapabilities();
        Assert.assertNotNull(capabilities.getCapability(CapabilityType.PROXY), "Proxy capability should exists.");
        Assert.assertEquals(((Proxy) capabilities.getCapability(CapabilityType.PROXY)).getProxyType(), Proxy.ProxyType.MANUAL,
                "Proxy type in capabilities should be DIRECT.");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");

        BrowserUpProxy proxy = ProxyPool.getOriginal(CustomProxy.class)
                .orElseThrow()
                .getProxy();
        // Saving har to a file...
        String name = "ProxyReport.har";
        File file = new File(ReportContext.getArtifactsFolder() + "/" + name);
        Assert.assertNotNull(proxy.getHar(), "Har is NULL!");

        try {
            proxy.getHar().writeTo(file);
            Artifact.attachToTest(name, file);
        } catch (IOException e) {
            LOGGER.error("Unable to generate har archive!", e);
        }
    }
}
