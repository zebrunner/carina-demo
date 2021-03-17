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

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.qaprosoft.carina.core.foundation.utils.resources.L10Nparser;
import com.qaprosoft.carina.demo.gui.pages.localizationSample.WikipediaHomePage;
import com.qaprosoft.carina.demo.gui.pages.localizationSample.WikipediaLocalePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.Locale;

/**
 * This sample shows how create Web Localization test with Resource Bundle.
 *
 * @author qpsdemo
 */

public class WebLocalizationSample extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testLanguages() {

        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        SoftAssert softAssert = new SoftAssert();

        WikipediaLocalePage wikipediaLocalePage = wikipediaHomePage.goToWikipediaLocalePage(getDriver());
        String welcomeText = wikipediaLocalePage.getWelcomeText();
        String expectedWelcomeText = L10N.getText("HomePage.welcomeText");

        softAssert.assertEquals(welcomeText, expectedWelcomeText.trim(), "Wikipedia welcome text was not the expected.");

        wikipediaLocalePage.clickDiscussionBtn();
        String expectedDiscussionText = L10N.getText("discussionElem");
        String discussionText = wikipediaLocalePage.getDiscussionText();

        softAssert.assertEquals(discussionText,expectedDiscussionText.trim(),"Wikipedia discussion text was not the expected");

        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    /**
     * _config.properties should be filled correctly.
     * For example: for Japan language you should use:
     * locale=ja_JP
     *
     * add_new_localization=true - for creation and false for checking.
     * add_new_localization_path=./src/main/resources/L10N/ - path for newly created l10n file
     * add_new_localization_encoding=UTF-8 (use ISO-2022-JP if you can't have UTF-8 property file or there are issues with comparison or interaction)
     * add_new_localization_property_name=new_locale_ - name of l10n file. Copy all required values in your existing locale_ja_JP.properties
     * Read more details in com.qaprosoft.carina.core.foundation.utils.resources.L10Nparser
     */
    public void testAddNewLanguages() {

        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        WikipediaLocalePage wikipediaLocalePage = wikipediaHomePage.goToWikipediaLocalePage(getDriver());
        String expectedWelcomeText = L10N.getText("HomePage.welcomeText");
        String welcomeText = wikipediaLocalePage.getWelcomeText();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(welcomeText, expectedWelcomeText.trim(), "Wikipedia welcome text was not the expected.");

        // To set correct locale for creating new localization text.
        // Can be changed dynamically during test execution.

        L10Nparser.setActualLocale(Configuration.get(Configuration.Parameter.LOCALE));
        Locale actualLocale = L10Nparser.getActualLocale();
        LOGGER.info(actualLocale.toString());

        sa.assertTrue(wikipediaLocalePage.checkMultipleLocalization(), "Localization error: " + L10Nparser.getAssertErrorMsg());

        L10Nparser.saveLocalization();
        sa.assertAll();
    }
}