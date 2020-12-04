package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.qaprosoft.carina.demo.gui.pages.localizationSample.WikipediaHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This sample shows how create Web Localization test with Resource Bundle.
 *
 * @author qpsdemo
 */

public class WebLocalizationSample extends AbstractTest {

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testLanguages() {

        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        String welcomeText = wikipediaHomePage.getWelcomeText();
        String expectedWelcomeText = L10N.getText("HomePage.welcomeText");

        Assert.assertEquals(welcomeText, expectedWelcomeText, "Wikipedia welcome text was not the expected.");

    }

}