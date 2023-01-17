package koval;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginCheckTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. login check. login with empty fields and unchecked buttons", value = {"mobile"})
    public void testAllEmpty() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }
    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "2. login check. login with empty fields and checked buttons", value = {"mobile"})
    public void testEmptyFields() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.selectFemaleSex();
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "3. login check. login by entering space to the fields(name, password)", value = {"mobile"})
    public void testFieldsWithSpace() {

    WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
    Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

    LoginPageBase loginPageBase = welcomePage.clickNextBtn();
    Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    loginPageBase.typeName(" ");
    loginPageBase.typePassword(" ");
    loginPageBase.selectFemaleSex();
    loginPageBase.checkPrivacyPolicyCheckbox();

    CarinaDescriptionPageBase carinaDescriptionPage = loginPageBase.clickLoginBtn();
    Assert.assertTrue(carinaDescriptionPage.isPageOpened(),"Page is not opened!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "4. login check. login without entering password", value = {"mobile"})
    public void testWithoutPasswordField() {
        String name = "Diana";

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.selectFemaleSex();
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "5. login check. login without entering name", value = {"mobile"})
    public void testWithoutNameField() {
        String password = "diana21";

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.typePassword(password);
        loginPageBase.selectFemaleSex();
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "6. login check. login with unchecked sex-radiobutton", value = {"mobile"})
    public void testWithSexUnchecked() {
        String name = "Diana";
        String password = "diana21";

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.typePassword(password);
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "7. login check. login with unchecked privacyPolicy-checkBox", value = {"mobile"})
    public void testWithPrivacyPolicyUnchecked() {
        String name = "Diana";
        String password = "diana21";

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.typePassword(password);
        loginPageBase.selectFemaleSex();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "8. login check. login with checked privacyPolicy-checkBox and field name", value = {"mobile"})
    public void testWithOnlyPrivacyPolicyChecked() {
        String name = "Diana";

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.checkPrivacyPolicyCheckbox();
        loginPageBase.typeName(name);

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "9. login check. login with checked privacyPolicy-checkBox and then unchecked", value = {"mobile"})
    public void testWithPrivacyPolicyChecked() {
        String name = "Diana";
        String password = "diana21";

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.typePassword(password);
        loginPageBase.selectFemaleSex();
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");

        loginPageBase.checkPrivacyPolicyCheckbox(); //unchecked
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "10. login check. login with checked only sex-radiobutton/empty name and password fields",
             value = {"mobile"})
    public void testOnlySexChecked() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.selectFemaleSex();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "11. login check. login with checked only privacyPolicy-checkBox/empty name and password fields",
            value = {"mobile"})
    public void testOnlyPrivacyPolicyChecked() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
    }
    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "12. login check. login by entering correct data to the fields", value = {"mobile"})
    public void testCorrectFields() {
        String name = "Diana";
        String password = "diana21";

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "Login button is active!");
        loginPageBase.typeName(name);
        loginPageBase.typePassword(password);
        loginPageBase.selectFemaleSex();
        loginPageBase.checkPrivacyPolicyCheckbox();

        CarinaDescriptionPageBase carinaDescriptionPage = loginPageBase.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(),"Page is not opened!");
    }

}
