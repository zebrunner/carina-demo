package com.qaprosoft.carina.demo.beatsbydre;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractHeader;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractRegistrationError;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.HomePageBase;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.RegisterBeatsPageBase;
import com.zebrunner.carina.utils.resources.L10N;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LocalizationTest extends AbstractBeatsByDreTest {

    @AfterClass
    public void addLocales() {
        L10N.flush();
    }

    @Test()
    public void testFooterLocale() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        AbstractFooter footer = homePage.getFooter();
        footer.getRootExtendedElement().hover();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(footer.getCopyright().isBlank(), "Footer's copyright text is not visible!");
        softAssert.assertFalse(footer.getProductsTitle().isBlank(), "Footer's product title text is not visible!");
        softAssert.assertFalse(footer.getSupportTitle().isBlank(), "Footer's support title text is not visible!");
        softAssert.assertFalse(footer.getCompanyTitle().isBlank(), "Footer's company title text is not visible!");
        softAssert.assertFalse(footer.getLicenseTitle().isBlank(), "Footer's license title text is not visible!");
        softAssert.assertFalse(footer.getMediaTitle().isBlank(), "Footer's media title text is not visible!");
        softAssert.assertFalse(footer.getLocationTitle().isBlank(), "Footer's location title text is not visible!");
        softAssert.assertFalse(footer.getLocationCountry().isBlank(), "Footer's country location text is not visible!");
        softAssert.assertFalse(footer.getChangeLocationButton().isBlank(), "Footer's change location button text is not visible!");
        softAssert.assertFalse(footer.getEmailTitle().isBlank(), "Footer's email title text is not visible!");
        softAssert.assertFalse(footer.getSignUpButton().isBlank(), "Footer's sign up button text is not visible!");
        softAssert.assertFalse(footer.getProductsList().isEmpty(), "Footer should contain product refs");
        softAssert.assertFalse(footer.getSupportList().isEmpty(), "Footer should contain support refs");
        softAssert.assertFalse(footer.getCompanyList().isEmpty(), "Footer should contain company info refs");
        softAssert.assertFalse(footer.getLicenseList().isEmpty(), "Footer should contain license info refs");
        softAssert.assertAll();

        L10N.assertAll();
    }

    @Test()
    public void testHeaderLocale() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        AbstractHeader header = homePage.getHeader();
        header.getRootExtendedElement().hover();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(header.getPromoText().isBlank(), "Header's promo text is not visible!");
        softAssert.assertTrue(header.getTitles().size() == 3, "Header should contain 3 nav buttons");
        softAssert.assertAll();
        L10N.assertAll();
    }

    @Test
    public void testDiscoverPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(homePage.getHeadphonesRegisterButtonText().isBlank(),
                "Headphones register button text is not visible!");
        softAssert.assertTrue(homePage.getPopularCardsNames().size() == 3,
                "Page should contain 3 popular cards with names");
        softAssert.assertTrue(homePage.getPopularCardsPrices().size() == 3,
                "Page should contain 3 popular cards with prices");
        softAssert.assertTrue(homePage.getFeatureTitleList().size() == 4,
                "Page should contain 4 feature cards with Titles");
        softAssert.assertTrue(homePage.getFeatureDescriptionList().size() == 4,
                "Page should contain 4 feature cards with description");
        softAssert.assertAll();
        L10N.assertAll();
    }

    @Test
    public void testRegisterPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        RegisterBeatsPageBase registerPage = homePage.toRegisterBeatsPage();
        registerPage.assertPageOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(registerPage.getPageTitle().isBlank(),
                "Headphones register page title is not visible!");
        softAssert.assertFalse(registerPage.getHowToFindSerNumberLink().isBlank(),
                "Headphones how to find ser number info is not visible!");

        String emptyString = StringUtils.EMPTY;
        String invalidCharsInput = "@11111111111";
        String invalidLengthInput = "1";
        String invalidSerNumberInput = "211111111111";
        registerPage.typeSerNumberField(emptyString);
        registerPage.verifySerNumber();
        softAssert.assertFalse(registerPage.getEmptyInputErrMsg().isBlank(),
                "Empty input error message didn't popped up");
        registerPage.typeSerNumberField(invalidCharsInput);
        registerPage.verifySerNumber();
        softAssert.assertFalse(registerPage.getInvalidCharsErrMsg().isBlank(),
                "Invalid chars error message didn't popped up");
        registerPage.typeSerNumberField(invalidLengthInput);
        registerPage.verifySerNumber();
        softAssert.assertFalse(registerPage.getLengthErrMsg().isBlank(),
                "Invalid length error message didn't popped up");

        registerPage.typeSerNumberField(invalidSerNumberInput);
        registerPage.verifySerNumber();
        AbstractRegistrationError registrationError = registerPage.getRegistrationError();
        softAssert.assertTrue(registrationError.isUIObjectPresent(),
                "Registration error modal didn't popped up");
        softAssert.assertFalse(registrationError.getErrorTitle().isBlank(),
                "Registration error modal should contain title");
        softAssert.assertFalse(registrationError.getSerNumberError().isBlank(),
                "Registration error modal should error info");
        registrationError.closeModal();
        softAssert.assertAll();
        L10N.assertAll();
    }

}
