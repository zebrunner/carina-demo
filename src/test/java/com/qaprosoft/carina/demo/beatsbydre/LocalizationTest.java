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
        L10N.assertAll();
    }

    @Test()
    public void testFooterLocale() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        AbstractFooter footer = homePage.getFooter();
        footer.interactWithLocalizedElements();
    }

    @Test()
    public void testHeaderLocale() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        AbstractHeader header = homePage.getHeader();
        header.interactWithLocalizedElements();
    }

    @Test
    public void testDiscoverPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        homePage.interactWithLocalizedElements();
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
    }

}
