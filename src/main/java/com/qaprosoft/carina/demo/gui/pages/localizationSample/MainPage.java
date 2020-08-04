/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
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

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='js-lang-lists']/div[1]/ul/li/a")
    private List<ExtendedWebElement> langList;

    @FindBy(id = "js-lang-list-button")
    private ExtendedWebElement langListBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String initEnglishPage(Languages lang) {
        langListBtn.clickIfPresent();
        for (ExtendedWebElement e : langList) {
            if (e.getText().equalsIgnoreCase(lang.getText())) {
                e.click();
                WikipediaHomePage_En home = new WikipediaHomePage_En(getDriver());
                return home.getWelcomeText();
            }
        }
        return null;
    }

    public String initSpanishPage(Languages lang) {
        langListBtn.clickIfPresent();
        for (ExtendedWebElement e : langList) {
            if (e.getText().equalsIgnoreCase(lang.getText())) {
                e.click();
                WikipediaHomePage_Es home = new WikipediaHomePage_Es(getDriver());
                return home.getWelcomeText();
            }
        }
        return null;
    }

    public String initFrenchPage(Languages lang) {
        langListBtn.clickIfPresent();
        for (ExtendedWebElement e : langList) {
            if (e.getText().equalsIgnoreCase(lang.getText())) {
                e.click();
                WikipediaHomePage_Fr home = new WikipediaHomePage_Fr(getDriver());
                return home.getWelcomeText();
            }
        }
        return null;
    }

    public String initPage(Languages lang) {
        switch (lang) {
            case ES:
                return initSpanishPage(lang);
            case FR:
                return initFrenchPage(lang);
            default:
                return initEnglishPage(lang);
        }
    }
}
