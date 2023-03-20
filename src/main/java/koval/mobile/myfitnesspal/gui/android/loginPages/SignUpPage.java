package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.TopToolbarModal;
import koval.mobile.myfitnesspal.gui.common.loginPages.CreateAccountPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.service.accountFactory.Account;
import koval.mobile.myfitnesspal.service.enums.ActivityLevel;
import koval.mobile.myfitnesspal.service.enums.Gender;
import koval.mobile.myfitnesspal.service.enums.HeightMeasure;
import koval.mobile.myfitnesspal.service.enums.WeightMeasure;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/toolbar")
    private TopToolbarModal topToolbarModal;


    @FindBy(xpath = "//*[@text='%s']|//*[@text='%s']")
    private ExtendedWebElement itemByText;


    @FindBy(id = "com.myfitnesspal.android:id/layout%s")
    private ExtendedWebElement activityLevelBlock;

    @FindBy(id = "com.myfitnesspal.android:id/textCountry")
    private ExtendedWebElement countryButton;

    @FindBy(id = "com.myfitnesspal.android:id/entry_%s")
    private ExtendedWebElement measurementParametersTextBox;

    @FindBy(id = "com.myfitnesspal.android:id/%s")
    private ExtendedWebElement measurementParametersSpinner;

    @FindBy(id = "com.myfitnesspal.android:id/%sEdit")
    private ExtendedWebElement loginParameterTextBox;

    @FindBy(id = "com.myfitnesspal.android:id/units")
    private ExtendedWebElement measureSpinner;

    @FindBy(className = "android.widget.CheckBox")
    private ExtendedWebElement privacyPolicyTermsCheckBox;

    @FindBy(id = "com.myfitnesspal.android:id/recyclerView")
    private List<ExtendedWebElement> countryList;

    @FindBy(id = "com.myfitnesspal.android:id/answer")
    private List<ExtendedWebElement> sourceList;

    @FindBy(id = "com.myfitnesspal.android:id/tv_goal")
    private List<ExtendedWebElement> goalsList;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public boolean isPageOpened(String textTitle) {
        return topToolbarModal.isPageOpened(textTitle);
    }


    @Override
    public SignUpPageBase acceptAllConsents() {

        if (privacyPolicyTermsCheckBox.isElementPresent(TIMEOUT_FIVE)) {
            privacyPolicyTermsCheckBox.click();
        }

        itemByText.format(ACCEPT).click();
        return initPage(getDriver(), SignUpPageBase.class);
    }


    @Override
    public SignUpPageBase privacyPolicyTermsAgreement() {

        if (privacyPolicyTermsCheckBox.isElementPresent(TIMEOUT_FIVE)) {
            privacyPolicyTermsCheckBox.click();
        }

        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public boolean isPrivacyPolicyTermsPresent() {

        return privacyPolicyTermsCheckBox.isElementPresent(TIMEOUT_FIVE);
    }


    @Override
    public SignUpPageBase checkGenderByName(Gender gender) {

        itemByText.format(gender.getGender()).check();

        return initPage(getDriver(), SignUpPageBase.class);
    }


    @Override
    public SignUpPageBase setMail(String mail) {

        loginParameterTextBox.format(EMAIL).type(mail, TIMEOUT_FIVE);

        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public SignUpPageBase setPassword(String password) {

        loginParameterTextBox.format(PASSWORD.toLowerCase()).type(password, TIMEOUT_FIVE);

        return initPage(getDriver(), SignUpPageBase.class);
    }


    @Override
    public SignUpPageBase setWeight(float weight, WeightMeasure weightMeasureValue) {

        String weightSpinnerID;
        if (topToolbarModal.getTitleText().equals(WEEKLY_GOAL)) {
            weightSpinnerID = INPUT_GOAL_WEIGHT;
        } else {
            weightSpinnerID = CURRENT_WEIGHT;
        }

        measurementParametersSpinner.format(weightSpinnerID).click();

        if (!itemByText.format(weightMeasureValue.getWeightMeasure()).isElementPresent(TIMEOUT_FIVE)) {
            measureSpinner.click();
            itemByText.format(weightMeasureValue.getWeightMeasure()).click();
        }

        if (weightMeasureValue.getWeightMeasure().equals(WeightMeasure.STONE.getWeightMeasure())) {
            String[] weightValue = String.valueOf(weight).split("\\.");
            int stoneValue = Integer.parseInt(weightValue[0]);
            int lbsValue = Integer.parseInt(weightValue[1]);

            if (!measurementParametersTextBox.format(ONE_VALUE).getText().equals(String.valueOf(stoneValue))) {
                measurementParametersTextBox.format(ONE_VALUE).type(String.valueOf(stoneValue), TIMEOUT_FIVE);
            }

            if (!measurementParametersTextBox.format(TWO_VALUE).getText().equals(String.valueOf(lbsValue))) {
                measurementParametersTextBox.format(TWO_VALUE).type(String.valueOf(lbsValue), TIMEOUT_FIVE);
            }


        } else {

            if (!measurementParametersTextBox.format(ONE_VALUE).getText().equals(String.valueOf(weight))) {
                measurementParametersTextBox.format(ONE_VALUE).type(String.valueOf((int) weight), TIMEOUT_FIVE);
            }


        }

        itemByText.format(SET).click();

        return initPage(getDriver(), SignUpPageBase.class);
    }


    @Override
    public SignUpPageBase setHeight(float height, HeightMeasure heightMeasureValue) {

        measurementParametersSpinner.format(HEIGHT).click();

        if (!itemByText.format(heightMeasureValue.getHeightMeasure()).isElementPresent(TIMEOUT_FIVE)) {
            measureSpinner.click();
            itemByText.format(heightMeasureValue.getHeightMeasure()).click();
        }

        if (heightMeasureValue.getHeightMeasure().equals(HeightMeasure.FEET_INCHES.getHeightMeasure())) {
            String[] heightValue = String.valueOf(height).split("\\.");
            int feetValue = Integer.parseInt(heightValue[0]);
            int inchesValue = Integer.parseInt(heightValue[1]);

            if (!measurementParametersTextBox.format(ONE_VALUE).getText().equals(String.valueOf(feetValue))) {
                measurementParametersTextBox.format(ONE_VALUE).type(String.valueOf(feetValue), TIMEOUT_FIVE);
            }

            if (!measurementParametersTextBox.format(TWO_VALUE).getText().equals(String.valueOf(inchesValue))) {
                measurementParametersTextBox.format(TWO_VALUE).type(String.valueOf(inchesValue), TIMEOUT_FIVE);
            }

        } else {

            if (!measurementParametersTextBox.format(ONE_VALUE).getText().equals(String.valueOf(height))) {
                measurementParametersTextBox.format(ONE_VALUE).type(String.valueOf((int) height), TIMEOUT_FIVE);
            }

        }

        itemByText.format(SET).click();

        return initPage(getDriver(), SignUpPageBase.class);
    }


    @Override
    public SignUpPageBase setAge(int age) {

        itemByText.format(AGE).type(String.valueOf(age), TIMEOUT_FIVE);

        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public SignUpPageBase setCountry(String country) {

        countryButton.click();

        String firstCountry = countryList.get(0).getText();

        int compareResult = firstCountry.compareTo(country);

        Direction direction = Direction.DOWN;

        if (compareResult > 0) {
            direction = Direction.UP;
        }

        ExtendedWebElement activityTitleElement = itemByText.format(country);
        swipe(activityTitleElement, direction, TWENTY_COUNT, MEDIUM_SPEED);
        activityTitleElement.click();

        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public WelcomePageBase clickReturnBackButton() {
        topToolbarModal.clickReturnBackButton();
        return initPage(getDriver(), WelcomePageBase.class);
    }

    @Override
    public SignUpPageBase clickButtonByText(String buttonText) {
//        if (itemByText.format(buttonText).isElementPresent(TIMEOUT_FIVE)) {
//            itemByText.format(buttonText).click();
//        } else {
//            itemByText.format(CONTINUE).click();

        //      }
        itemByText.format(CONTINUE, NEXT);

        return initPage(getDriver(), SignUpPageBase.class);
    }


    @Override
    public boolean isItemFromGoalListSelectedByIndex(int index) {

        return isItemFromListSelectedByIndex(index, goalsList, GOALS);
    }


    @Override
    public boolean isItemFromActivityLevelListSelectedByIndex(ActivityLevel activityLevel) {

        String activityLevelText = activityLevel.getActivityLevel();

        if (!activityLevelBlock.format(activityLevelText).isElementPresent(TIMEOUT_FIVE)) {
            Assert.fail("[ SIGN UP PAGE ] List of activity level is empty or index is out of the bounds!");
        }
        return Boolean.parseBoolean(activityLevelBlock.getAttribute(CHECKED));
    }

    @Override
    public SignUpPageBase selectItemFromActivityLevelListByIndex(ActivityLevel activityLevel) {

        String activityLevelText = activityLevel.getActivityLevel();

        if (!activityLevelBlock.format(activityLevelText).isElementPresent(TIMEOUT_FIVE)) {
            Assert.fail("[ SIGN UP PAGE ] List of activity level is empty or index is out of the bounds!");
        }

        activityLevelBlock.format(activityLevelText).click();

        return initPage(getDriver(), SignUpPageBase.class);
    }


    @Override
    public SignUpPageBase selectItemFromGoalsListByIndex(int index) {

        return selectItemFromListByIndex(index, goalsList, GOALS);
    }

    @Override
    public SignUpPageBase savePasswordToGoogleAgreement(boolean result) {

        if (itemByText.format("Save password to Google?").isElementPresent(TIMEOUT_FIVE)) {
            if (result) {
                itemByText.format("Save").clickIfPresent();
            } else {
                itemByText.format("No thanks").clickIfPresent();
            }
        }
        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public SignUpPageBase selectItemFromSourceListByIndex(int index) {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(itemByText.format("How did you hear about us?").getBy()), TIMEOUT_FIFTEEN);

        return selectItemFromListByIndex(index, sourceList, SOURCE);
    }

    @Override
    public SignUpPageBase selectItemFromListByIndex(int index, List<ExtendedWebElement> listOfElements, String message) {

        if (listOfElements.isEmpty() || listOfElements.size() < index) {
            Assert.fail(String.format("[ SIGN UP PAGE ] List of '%s' is empty or index is out of the bounds!", message));
        }

        listOfElements.get(index).click();

        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public boolean isItemFromListSelectedByIndex(int index, List<ExtendedWebElement> listOfElements, String message) {

        if (listOfElements.isEmpty() || listOfElements.size() < index) {
            Assert.fail(String.format("[ SIGN UP PAGE ] List of '%s' is empty or index is out of the bounds!", message));
        }

        return Boolean.parseBoolean(listOfElements.get(index).getAttribute(CHECKED));
    }

    @Override
    public SignUpPageBase createRandomAccount(Account account) {
        return initPage(getDriver(), CreateAccountPageBase.class).createRandomAccount(account);
    }

}
