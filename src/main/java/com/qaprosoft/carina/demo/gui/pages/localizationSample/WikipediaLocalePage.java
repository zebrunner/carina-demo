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
package com.qaprosoft.carina.demo.gui.pages.localizationSample;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Localized;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class WikipediaLocalePage extends AbstractPage {

    @Localized
    @FindBy(xpath = "//*[@class='mw-headline' or @class='welcome-title' or @id='welcome']")
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

    public WikipediaLocalePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText(){
        if (welcomeText.isPresent()) {
            return welcomeText.getText();
        }
        return "";
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
