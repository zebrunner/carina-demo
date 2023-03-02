/*******************************************************************************
 * Copyright 2013-2020 QaProSoft (http://www.qaprosoft.com).
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

package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.gui.pages.desktop.WikipediaHomePage;
import com.qaprosoft.carina.demo.gui.pages.desktop.WikipediaLocalePage;
import com.zebrunner.carina.utils.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.resources.L10N;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

/**
 * This sample shows how create Web Localization test with Resource Bundle.
 *
 * @author qpsdemo
 */

public class WebLocalizationSample implements IAbstractTest {

    @BeforeClass
    public void testLocaleLoad() {
        Locale locale = L10N.getLocale();
        String loadedLocale = locale.getLanguage() + "_" + locale.getCountry();
        String configLocale = Configuration.get(Configuration.Parameter.LOCALE);
        Assert.assertEquals(loadedLocale, configLocale);
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = "l10n")
    public void testLanguages() {
        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        WikipediaLocalePage wikipediaLocalePage = wikipediaHomePage.goToWikipediaLocalePage(getDriver());

        wikipediaLocalePage.clickMoreButton();
        wikipediaLocalePage.hoverContribElem();
        wikipediaLocalePage.clickDiscussionBtn();

        L10N.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = "l10n")
    public void testAddNewLanguages() {
        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        WikipediaLocalePage wikipediaLocalePage = wikipediaHomePage.goToWikipediaLocalePage(getDriver());

        wikipediaLocalePage.hoverCreateAccountElem();
        wikipediaLocalePage.hoverWelcomeText();

        wikipediaLocalePage.hoverHeaders();

        wikipediaLocalePage.clickMoreButton();
        wikipediaLocalePage.hoverContribElem();
        wikipediaLocalePage.clickDiscussionBtn();

        L10N.flush();
        L10N.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = "l10n")
    public void testElementsSearchWithL10n() {
        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        WikipediaLocalePage wikipediaLocalePage = wikipediaHomePage.goToWikipediaLocalePage(getDriver());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(wikipediaLocalePage.isWelcomeTextPresent());
        String actual = wikipediaLocalePage.getDiscussionText();
        String expected = L10N.getText("WikipediaLocalePage.discussionElem");
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
    }
}