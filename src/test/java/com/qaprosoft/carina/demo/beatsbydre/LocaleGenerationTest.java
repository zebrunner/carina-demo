package com.qaprosoft.carina.demo.beatsbydre;

import com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.common.AbstractFooterGen;
import com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.common.AbstractHeaderGen;
import com.qaprosoft.carina.demo.beatsbydre.locale.generate.gui.common.HomePageBaseGen;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LocaleGenerationTest extends AbstractBeatsByDreTest {
    @BeforeClass
    public void enableLocaleGeneration() {
        R.CONFIG.put(Configuration.Parameter.LOCALIZATION_TESTING.getKey(), "true");
    }

    @AfterClass
    public void addLocales() {
        L10N.flush();
    }

    @Test()
    public void generateFooter() {
        HomePageBaseGen homePage = initPage(getDriver(), HomePageBaseGen.class);
        homePage.open();
        homePage.assertPageOpened();

        AbstractFooterGen footerGen = homePage.getFooterGen();
        footerGen.getRootExtendedElement().hover();
        footerGen.hoverFooterItems();
    }

    @Test()
    public void generateHeader() {
        HomePageBaseGen homePage = initPage(getDriver(), HomePageBaseGen.class);
        homePage.open();
        homePage.assertPageOpened();
        AbstractHeaderGen header = homePage.getHeader();
        header.getRootExtendedElement().hover();
        header.hoverHeaderItems();
    }

    @Test
    public void generateDiscoverPage() {
        HomePageBaseGen homePage = initPage(getDriver(), HomePageBaseGen.class);
        homePage.open();
        homePage.assertPageOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getPopularCardsNames().size() == 3,
                "Page should contain 3 popular cards with names");
        softAssert.assertTrue(homePage.getPopularCardsPrices().size() == 3,
                "Page should contain 3 popular cards with prices");
        softAssert.assertTrue(homePage.getFeatureDescriptionList().size() == 4,
                "Page should contain 4 feature cards with description");
        softAssert.assertAll();
    }

}
