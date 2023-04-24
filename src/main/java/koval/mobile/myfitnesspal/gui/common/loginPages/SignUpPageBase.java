package koval.mobile.myfitnesspal.gui.common.loginPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.service.factories.accountFactory.Account;
import koval.mobile.myfitnesspal.service.enums.ActivityLevel;
import koval.mobile.myfitnesspal.service.enums.Gender;
import koval.mobile.myfitnesspal.service.enums.HeightMeasure;
import koval.mobile.myfitnesspal.service.enums.WeightMeasure;
import org.openqa.selenium.WebDriver;

import java.util.List;


public abstract class SignUpPageBase extends MyAbstractPageBase {

    public SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String textTitle);

    public abstract SignUpPageBase acceptAllConsents();

    public abstract SignUpPageBase privacyPolicyTermsAgreement();


    public abstract boolean isPrivacyPolicyTermsPresent();

    public abstract SignUpPageBase checkGenderByName(Gender gender);


    public abstract SignUpPageBase setMail(String mail);

    public abstract SignUpPageBase setPassword(String password);

    public abstract SignUpPageBase setWeight(float weight, WeightMeasure weightMeasureValue);

    public abstract SignUpPageBase setHeight(float height, HeightMeasure heightMeasureValue);

    public abstract SignUpPageBase setAge(int age);

    public abstract SignUpPageBase setCountry(String country);

    public abstract WelcomePageBase clickReturnBackButton();


    public abstract SignUpPageBase clickButtonByText(String buttonText);


    public abstract boolean isItemFromGoalListSelectedByIndex(int index);


    public abstract boolean isItemFromActivityLevelListSelectedByIndex(ActivityLevel activityLevel);

    public abstract SignUpPageBase selectItemFromActivityLevelListByIndex(ActivityLevel activityLevel);

    public abstract SignUpPageBase selectItemFromGoalsListByIndex(int index);

    public abstract SignUpPageBase savePasswordToGoogleAgreement(boolean result);

    public abstract SignUpPageBase selectItemFromSourceListByIndex(int index);

    public abstract SignUpPageBase selectItemFromListByIndex(int index, List<ExtendedWebElement> listOfElements, String message);

    public abstract boolean isItemFromListSelectedByIndex(int index, List<ExtendedWebElement> listOfElements, String message);

    public abstract SignUpPageBase createRandomAccount(Account account);

    public abstract DashboardPageBase closeNoSubscriptionsPopUpIfPresent();
}
