package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.qaprosoft.carina.core.foundation.utils.resources.L10Nparser;
import com.qaprosoft.carina.demo.gui.pages.localizationSample.WikipediaHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
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

        String welcomeText = wikipediaHomePage.getWelcomeText();
        String expectedWelcomeText = L10N.getText("HomePage.welcomeText");

        Assert.assertEquals(welcomeText, expectedWelcomeText, "Wikipedia welcome text was not the expected.");

        wikipediaHomePage.clickDiscussionBtn();
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

        String welcomeText = wikipediaHomePage.getWelcomeText();
        String expectedWelcomeText = L10N.getText("HomePage.welcomeText");
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(welcomeText, expectedWelcomeText, "Wikipedia welcome text was not the expected.");

        // To set correct locale for creating new localization text.
        // Can be changed dynamically during test execution.
        L10Nparser.setActualLocale(Configuration.get(Configuration.Parameter.LOCALE));

        Locale actualLocale = L10Nparser.getActualLocale();
        LOGGER.info(actualLocale.toString());

        L10Nparser.setActualLocale(actualLocale);

        sa.assertTrue(wikipediaHomePage.checkLocalization(actualLocale), "Localization error: " + L10Nparser.getAssertErrorMsg());

        sa.assertTrue(wikipediaHomePage.checkMultipleLocalization(actualLocale), "Localization error: " + L10Nparser.getAssertErrorMsg());

        L10Nparser.saveLocalization();
        sa.assertAll();
    }

}