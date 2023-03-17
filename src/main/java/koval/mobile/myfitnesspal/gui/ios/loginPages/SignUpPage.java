package koval.mobile.myfitnesspal.gui.ios.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.service.accountFactory.Account;
import koval.mobile.myfitnesspal.service.enums.ActivityLevel;
import koval.mobile.myfitnesspal.service.enums.Gender;
import koval.mobile.myfitnesspal.service.enums.HeightMeasure;
import koval.mobile.myfitnesspal.service.enums.WeightMeasure;
import org.openqa.selenium.WebDriver;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String textTitle) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase acceptAllConsents() {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase privacyPolicyTermsAgreement() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPrivacyPolicyTermsPresent() {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase checkGenderByName(Gender gender) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase setMail(String mail) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase setPassword(String password) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase setWeight(float weight, WeightMeasure weightMeasureValue) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase setHeight(float height, HeightMeasure heightMeasureValue) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase setAge(int age) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase setCountry(String country) {
        throw new NotImplementedException();
    }

    @Override
    public WelcomePageBase clickReturnBackButton() {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase clickButtonByText(String buttonText) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isItemFromGoalListSelectedByIndex(int index) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isItemFromActivityLevelListSelectedByIndex(ActivityLevel activityLevel) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase selectItemFromActivityLevelListByIndex(ActivityLevel activityLevel) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase selectItemFromGoalsListByIndex(int index) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase savePasswordToGoogleAgreement(boolean result) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase selectItemFromSourceListByIndex(int index) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase selectItemFromListByIndex(int index, List<ExtendedWebElement> listOfElements, String message) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isItemFromListSelectedByIndex(int index, List<ExtendedWebElement> listOfElements, String message) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase createRandomAccount(Account account) {
        throw new NotImplementedException();
    }


}
