package koval;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.CarinaDescriptionPageBase;
import koval.mobile.gui.pages.common.LoginPageBase;
import koval.mobile.gui.pages.common.WelcomePageBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import koval.mobile.gui.pages.service.enums.Gender;


public class LoginCheckTest implements IAbstractTest, IMobileUtils {

    final String spaceFields = " ";
    final Gender femaleGender = Gender.valueOf("FEMALE");

    @DataProvider(name = "Name_Password")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"Diana", RandomStringUtils.randomAlphabetic(5), "[ LOGIN PAGE ] Valid data!"},
                {"Yana", RandomStringUtils.randomAlphabetic(5), "[ LOGIN PAGE ] Valid data!"},
                {" ", RandomStringUtils.randomAlphabetic(5), "[ LOGIN PAGE ] Invalid data!"}
        };
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. login check. login with empty fields and unchecked buttons", value = {"mobile"})
    public void testAllEmpty() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "2. login check. login with empty fields and checked buttons", value = {"mobile"})
    public void testEmptyFields() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.selectGender(femaleGender);
        Assert.assertTrue(loginPageBase.isSelectedGenderChecked(femaleGender), "[ LOGIN PAGE ] Selected gender is wrong!");
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "3. login check. login by entering space to the fields(name, password)", value = {"mobile"})
    public void testFieldsWithSpace() {

        boolean isAnyGenderChecked = false;

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.typeName(spaceFields);
        loginPageBase.typePassword(spaceFields);
        loginPageBase.selectGender(femaleGender);
        loginPageBase.checkPrivacyPolicyCheckbox();

        for (Gender gender : Gender.values())
            if(loginPageBase.isSelectedGenderChecked(gender)){
                isAnyGenderChecked = true;
            }

        Assert.assertTrue(isAnyGenderChecked, "[ LOGIN PAGE ] No gender is selected!");

//        for (Gender gender : Gender.values())
//            Assert.assertTrue(loginPageBase.isSelectedGenderChecked(gender), "[ LOGIN PAGE ] No gender is selected!");

        CarinaDescriptionPageBase carinaDescriptionPage = loginPageBase.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "[ CARINA DESCRIPTION PAGE ]Page is not opened!");
    }

    @Test(dataProvider = "Name_Password")
    @MethodOwner(owner = "koval")
    @TestLabel(name = "4. login check. login without entering password", value = {"mobile"})
    public void testWithoutPasswordField(String name, String passsword, String massage) {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        Assert.assertNotEquals(name, spaceFields, massage);
        loginPageBase.typeName(name);
        loginPageBase.selectGender(femaleGender);
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test(dataProvider = "Name_Password")
    @MethodOwner(owner = "koval")
    @TestLabel(name = "5. login check. login without entering name", value = {"mobile"})
    public void testWithoutNameField(String name, String password, String massage) {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.typePassword(password);
        loginPageBase.selectGender(femaleGender);
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test(dataProvider = "Name_Password")
    @MethodOwner(owner = "koval")
    @TestLabel(name = "6. login check. login with unchecked sex-radiobutton", value = {"mobile"})
    public void testWithSexUnchecked(String name, String password, String massage) {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.typePassword(password);
        loginPageBase.checkPrivacyPolicyCheckbox();

        for (Gender gender : Gender.values())
            Assert.assertFalse(loginPageBase.isSelectedGenderChecked(gender), "[ LOGIN PAGE ] Gender is checked!");

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test(dataProvider = "Name_Password")
    @MethodOwner(owner = "koval")
    @TestLabel(name = "7. login check. login with unchecked privacyPolicy-checkBox", value = {"mobile"})
    public void testWithPrivacyPolicyUnchecked(String name, String password, String massage) {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.typePassword(password);
        loginPageBase.selectGender(femaleGender);

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test(dataProvider = "Name_Password")
    @MethodOwner(owner = "koval")
    @TestLabel(name = "8. login check. login with checked privacyPolicy-checkBox and field name", value = {"mobile"})
    public void testWithOnlyPrivacyPolicyChecked(String name, String password, String massage) {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.checkPrivacyPolicyCheckbox();
        loginPageBase.typeName(name);

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test(dataProvider = "Name_Password")
    @MethodOwner(owner = "koval")
    @TestLabel(name = "9. login check. login with checked privacyPolicy-checkBox and then unchecked", value = {"mobile"})
    public void testWithPrivacyPolicyChecked(String name, String password, String massage) {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.typePassword(password);
        loginPageBase.selectGender(femaleGender);
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");

        loginPageBase.checkPrivacyPolicyCheckbox();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "10. login check. login with checked only sex-radiobutton/empty name and password fields",
            value = {"mobile"})
    public void testOnlySexChecked() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.selectGender(femaleGender);

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "11. login check. login with checked only privacyPolicy-checkBox/empty name and password fields",
            value = {"mobile"})
    public void testOnlyPrivacyPolicyChecked() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
    }

    @Test(dataProvider = "Name_Password")
    @MethodOwner(owner = "koval")
    @TestLabel(name = "12. login check. login by entering correct data to the fields", value = {"mobile"})
    public void testCorrectFields(String name, String password, String massage) {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.typePassword(password);
        loginPageBase.selectGender(femaleGender);
        loginPageBase.checkPrivacyPolicyCheckbox();

        CarinaDescriptionPageBase carinaDescriptionPage = loginPageBase.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "[ CARINA DESCRIPTION PAGE ] Page is not opened!");
    }

}
