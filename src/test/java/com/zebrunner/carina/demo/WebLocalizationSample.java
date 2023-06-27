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

package com.zebrunner.carina.demo;

import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.desktop.WikipediaHomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.WikipediaLocalePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.resources.L10N;

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
    public void testLanguages1() {
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
    public void testLanguages2() {
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
    public void testLanguages3() {
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
    public void testLanguages4() {
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
    public void testLanguages5() {
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
    public void testLanguages6() {
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
    public void testLanguages7() {
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
    public void testLanguages8() {
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
    public void testLanguages9() {
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
    public void testLanguages10() {
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
    public void testLanguages11() {
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
    public void testLanguages12() {
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
    public void testLanguages13() {
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
    public void testLanguages14() {
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
    public void testLanguages15() {
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
    public void testLanguages16() {
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
    public void testLanguages17() {
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
    public void testLanguages18() {
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
    public void testLanguages19() {
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
    public void testLanguages20() {
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
    public void testLanguages21() {
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
    public void testLanguages22() {
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
    public void testLanguages23() {
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
    public void testLanguages24() {
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
    public void testLanguages25() {
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
    public void testLanguages26() {
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
    public void testLanguages27() {
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
    public void testLanguages28() {
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
    public void testLanguages29() {
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
    public void testLanguages30() {
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
    public void testLanguages31() {
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
    public void testLanguages32() {
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
    public void testLanguages33() {
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
    public void testLanguages34() {
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
    public void testLanguages35() {
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
    public void testAddNewLanguages36() {
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
