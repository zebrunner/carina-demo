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
package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.WeValuePrivacyAd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(css = ".tip-icon")
    private ExtendedWebElement tipUsIcon;

    @FindBy(css = ".head-icon.icon-soc-fb2")
    private ExtendedWebElement faceBookIcon;

    @FindBy(css = ".head-icon.icon-soc-twitter2")
    private ExtendedWebElement twitterIcon;

    @FindBy(css = ".head-icon.icon-instagram")
    private ExtendedWebElement instagramIcon;

    @FindBy(css = ".head-icon.icon-soc-youtube")
    private ExtendedWebElement youtubeIcon;

    @FindBy(css = ".head-icon.icon-soc-rss2")
    private ExtendedWebElement rssIcon;

    @FindBy(css = ".head-icon.icon-login")
    private ExtendedWebElement loginIcon;

    @FindBy(css = ".head-icon.icon-user-plus")
    private ExtendedWebElement userIcon;

    @FindBy(xpath = "//a[@id='login-active']/span")
    private ExtendedWebElement textLoggedInUser;

    @FindBy(xpath = "//div[@class='normal-text res-error']/child::p")
    private ExtendedWebElement textFromLoginPage;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public BrandModelsPage selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }

    public WeValuePrivacyAd getWeValuePrivacyAd() {
        return new WeValuePrivacyAd(driver);
    }

    public boolean isTipUsIconPresent() {
        return tipUsIcon.isElementPresent();
    }

    public boolean isFaceBookIconPresent() {
        return faceBookIcon.isElementPresent();
    }

    public boolean isTwitterIconPresent() {
        return twitterIcon.isElementPresent();
    }

    public boolean isInstagramIconPresent() {
        return instagramIcon.isElementPresent();
    }

    public boolean isYoutubeIconPresent() {
        return youtubeIcon.isElementPresent();
    }

    public boolean isRssIconPresent() {
        return rssIcon.isElementPresent();
    }

    public boolean isLoginIconPresent() {
        return loginIcon.isElementPresent();
    }

    public boolean isUserIconPresent() {
        return userIcon.isElementPresent();
    }

    public String getTitleFromLoginPage() {
        return getDriver().getTitle();
    }

    public String getTextFromLoginPage() {
        assertElementPresent(textFromLoginPage);
        LOGGER.info("User record not found");
        return textFromLoginPage.getText();
    }
}
