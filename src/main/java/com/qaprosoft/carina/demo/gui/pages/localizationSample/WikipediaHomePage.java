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

import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.qaprosoft.carina.core.foundation.utils.resources.L10Nparser;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class WikipediaHomePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='js-lang-lists']//a")
    private List<ExtendedWebElement> langList;

    @FindBy(id = "js-lang-list-button")
    private ExtendedWebElement langListBtn;

    @FindBy(id = "{L10N:HomePage.welcomeTextId}")
    private ExtendedWebElement welcomeText;

    @FindBy(id = "pt-anontalk")
    private ExtendedWebElement discussionElem;

    @FindBy(id = "pt-anoncontribs")
    private ExtendedWebElement contribElem;

    @FindBy(id = "pt-createaccount")
    private ExtendedWebElement createAccountElem;

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.wikipedia.org/");
    }

    public String getWelcomeText() {
        langListBtn.clickIfPresent();
        if (!langList.isEmpty()) {
            for (ExtendedWebElement languageBtn : langList) {
                if (languageBtn.getAttribute("lang").equals(L10N.getDefaultLocale().getLanguage())) {
                    languageBtn.click();
                    if (welcomeText.isPresent()) {
                        return welcomeText.getText();
                    }
                    return "";
                }
            }
        }
        return null;
    }

    public void openLangList() {
        langListBtn.clickIfPresent();
    }

    public boolean checkLocalization(Locale actualLocale) {
        L10Nparser.setActualLocale(actualLocale);
        boolean ret = L10Nparser.checkLocalizationText(contribElem, "HomePage.contribElem");
        L10Nparser.saveLocalization();
        return ret;
    }

    public boolean checkMultipleLocalization(Locale actualLocale) {
        ExtendedWebElement[] localizationCheckList = {discussionElem, createAccountElem, contribElem, welcomeText};
        L10Nparser.setActualLocale(actualLocale);
        boolean ret = L10Nparser.checkMultipleLocalization(localizationCheckList, false);
        L10Nparser.saveLocalization();
        return ret;
    }
}
