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

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.resources.annotation.L10NElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WikipediaLocalePage extends AbstractPage {

    @L10NElement
    @FindBy(xpath = "//*[@id='{L10N:HomePage.welcomeTextId}' or @class='welcome-title']")
    private ExtendedWebElement welcomeText;

    @L10NElement
    @FindBy(xpath = "//nav[@id='p-navigation']/descendant::ul[@class='vector-menu-content-list']/*")
    private List<ExtendedWebElement> pageLinks;

    @L10NElement
    @FindBy(id = "pt-anoncontribs")
    private ExtendedWebElement contribElem;

    @L10NElement
    @FindBy(id = "pt-createaccount")
    private ExtendedWebElement createAccountElem;

    @L10NElement
    @FindBy(id = "pt-anontalk")
    private ExtendedWebElement discussionElem;

    @FindBy(linkText = "{L10N:discussionElem}")
    private ExtendedWebElement discussionBtn;

    public String getDiscussionText(){
        if (discussionBtn.isPresent()) {
            return discussionBtn.getText();
        }
        return "";
    }

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

    public void hoverHeaders(){
        for (ExtendedWebElement pageLink: pageLinks) {
            pageLink.hover();
        }
    }
}
