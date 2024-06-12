package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.webdriver.helper.IPageStorageHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.html5.RemoteLocalStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class LocalStorageTest implements IAbstractTest, IPageStorageHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void addItemToTheLocalStorageWithJS() throws IOException {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        String name = RandomStringUtils.randomAlphabetic(5);
        String value = RandomStringUtils.randomAlphabetic(10);
        LOGGER.info("[JS] Adding item to the local storage with name = '{}' and value '{}'...", name, value);
        ((JavascriptExecutor) getDriver())
                .executeScript("window.localStorage.setItem(arguments[0], arguments[1]);", name, value);
        String esgvalue = String.valueOf(getValueFromLocalStorage(name).orElse(""));
        Assert.assertEquals(esgvalue, value, "Value is not present or is not equal");
        LOGGER.info("Item in the local storage from esg with name = '{}' and value '{}' exists.", name, esgvalue);
    }

    @Test
    public void addItemToTheLocalStorageWithAugmentedDriver() throws IOException {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        String name = RandomStringUtils.randomAlphabetic(5);
        String value = RandomStringUtils.randomAlphabetic(10);
        LOGGER.info("[Augmenter] Adding item to the local storage with name = '{}' and value '{}'...", name, value);
        WebDriver augmentedDriver = new Augmenter().augment(getDriver());

        RemoteLocalStorage remoteLocalStorage = (RemoteLocalStorage) ((WebStorage)augmentedDriver).getLocalStorage();
        remoteLocalStorage.setItem(name, value);
        String esgvalue = String.valueOf(getValueFromLocalStorage(name).orElse(""));
        Assert.assertEquals(esgvalue, value, "Value is not present or is not equal");
        LOGGER.info("Item in the local storage from esg with name = '{}' and value '{}' exists.", name, esgvalue);
    }
}
