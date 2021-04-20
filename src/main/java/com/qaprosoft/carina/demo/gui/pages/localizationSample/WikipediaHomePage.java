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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WikipediaHomePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='js-lang-lists']//a")
    private List<ExtendedWebElement> langList;

    @FindBy(id = "js-lang-list-button")
    private ExtendedWebElement langListBtn;

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.wikipedia.org/");
    }

    public WikipediaLocalePage goToWikipediaLocalePage(WebDriver driver) {
        openLangList();
        if (!langList.isEmpty()) {
            for (ExtendedWebElement languageBtn : langList) {
                if (languageBtn.getAttribute("lang").equals(L10N.getDefaultLocale().getLanguage())) {
                    languageBtn.click();
                    return new WikipediaLocalePage(driver);
                }
            }
        }
        throw new RuntimeException("No language ref was found");
    }

    public void openLangList() {
        langListBtn.clickIfPresent();
    }

}
