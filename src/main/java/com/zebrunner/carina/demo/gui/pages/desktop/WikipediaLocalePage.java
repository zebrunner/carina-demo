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
package com.zebrunner.carina.demo.gui.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class WikipediaLocalePage extends AbstractPage {

    @Localized
    @FindBy(xpath = "//*[@id='{L10N:WikipediaLocalePage.welcomeTextId}' " +
            "or contains(text(),'{L10N:WikipediaLocalePage.welcomeText}') " +
            "or @class='welcome-title']")
    private ExtendedWebElement welcomeText;

    @Localized
    @FindBy(xpath = "//*[@id='p-navigation']//ul/li[not(@style)]")
    private List<ExtendedWebElement> pageLinks;

    @Localized
    @FindBy(id = "pt-anoncontribs")
    private ExtendedWebElement contribElem;

    @Localized
    @FindBy(xpath = "//li[@id='pt-createaccount' or @id='pt-createaccount-2']")
    private ExtendedWebElement createAccountElem;

    @Localized
    @FindBy(id = "pt-anontalk")
    private ExtendedWebElement discussionElem;

    @FindBy(xpath = "//input[@id='vector-user-links-dropdown-checkbox']/parent::div")
    private ExtendedWebElement moreButton;

    @FindBy(id = "mw-sidebar-button")
    private ExtendedWebElement navButton;

    @FindBy(xpath = "//*[contains(text(),'{L10N:WikipediaLocalePage.discussionElem}')]")
    private ExtendedWebElement discussionBtn;

    public WikipediaLocalePage(WebDriver driver) {
        super(driver);
    }

    public String getDiscussionText(){
        moreButton.clickIfPresent();
        if (discussionBtn.isPresent()) {
            return discussionBtn.getText();
        }
        return "";
    }

    public String getWelcomeText(){
        if (welcomeText.isPresent()) {
            return welcomeText.getText();
        }
        return "";
    }

    public boolean isWelcomeTextPresent(){
        return welcomeText.isPresent();
    }

    public void hoverWelcomeText(){
        welcomeText.hover();
    }

    public void hoverContribElem(){
        contribElem.hover();
    }

    public void hoverCreateAccountElem(){
        createAccountElem.hover();
    }

    public void clickDiscussionBtn() {
        discussionElem.click();
    }

    public void clickMoreButton(){
        moreButton.clickIfPresent();
    }

    public void hoverHeaders(){
        navButton.clickIfPresent();
        for (ExtendedWebElement pageLink: pageLinks) {
            pageLink.hover();
        }
    }

}
