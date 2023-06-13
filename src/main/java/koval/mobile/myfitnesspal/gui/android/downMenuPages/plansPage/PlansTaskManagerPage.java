package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.workout.LogWorkoutPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansTaskManagerPageBase.class)
public class PlansTaskManagerPage extends PlansTaskManagerPageBase {


    @FindBy(id = "com.myfitnesspal.android.plans:id/hubRecyclerView")
    private ExtendedWebElement plansContainer;

    @FindBy(id = "com.myfitnesspal.android.plans:id/planSurveyTitle")
    private ExtendedWebElement surveyTitle;

    @FindBy(id = "com.myfitnesspal.android.plans:id/what_do_you_think")
    private ExtendedWebElement whatDoYouThinkTitle;

    @FindBy(id = "com.myfitnesspal.android.plans:id/take_the_survey")
    private ExtendedWebElement takeTheSurveyTitle;


    @FindBy(id = "com.myfitnesspal.android.plans:id/action_show_plans_hub")
    private ExtendedWebElement addPlansPlusButton;

    @FindBy(id = "com.myfitnesspal.android.plans:id/welcomeActionBtn")
    private ExtendedWebElement welcomeActionButton;


    @FindBy(id = "com.myfitnesspal.android.plans:id/planTitle")
    private ExtendedWebElement planTitle;

    @FindBy(id = "com.myfitnesspal.android:id/btnDate")
    private ExtendedWebElement dateLabel;

    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    @FindBy(id = "com.myfitnesspal.android.plans:id/task_day_more_menu")
    private ExtendedWebElement moreMenu;

    @FindBy(id = "com.myfitnesspal.android.plans:id/logWorkout")
    private ExtendedWebElement logWorkoutButton;



    @FindBy(id = "com.myfitnesspal.android:id/snackbar_action")
    private ExtendedWebElement viewButton;


    @FindBy(id = "com.myfitnesspal.android:id/snackbar_text")
    private ExtendedWebElement workoutLoggedMessage;

    public PlansTaskManagerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        return dateLabel.isElementPresent(timeout);
    }

    @Override
    public String getCurrentPlanTitle() {
        return planTitle.getText();
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }



    @Override
    public boolean isSurveyTitleAtTheBottom() {
        Point point = getLocationElement();
        swipeUp(1, MEDIUM_SPEED);
        return getLocationElement().getY() == point.getY();
    }

    @Override
    public boolean isLoggedWorkoutConfirmMsgPresent() {
        return workoutLoggedMessage.isElementPresent(TIMEOUT_TEN) &&
                workoutLoggedMessage.getText().equals("Workout logged.");
    }




    @Override
    public LogWorkoutPageBase clickLogWorkoutButton() {
       logWorkoutButton.click(TIMEOUT_TEN);
        return initPage(getDriver(), LogWorkoutPageBase.class);
    }


    @Override
    public DiaryPageBase clickViewButton() {
        viewButton.click(TIMEOUT_TEN);
        return initPage(getDriver(), DiaryPageBase.class);
    }




    @Override
    public PlansHubPageBase clickOnPlusSign() {
        addPlansPlusButton.click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansHubPageBase.class);
    }

    @Override
    public PlansHubPageBase endPlan() {
        moreMenu.click(TIMEOUT_TEN);
        itemByText.format(END_PLAN).click(TIMEOUT_TEN);
        itemByText.format(END).click(TIMEOUT_TEN);
        return initPage(getDriver(), PlansHubPageBase.class);
    }


    @Override
    public PlansTaskManagerPageBase closeWelcomeMessageIfPresent(int timeout) {
        welcomeActionButton.clickIfPresent(timeout);
        return initPage(getDriver(), PlansTaskManagerPageBase.class);
    }

    @Override
    public PlansTaskManagerPageBase swipeToSurveyTitle(int timeout) {
        swipe(takeTheSurveyTitle, plansContainer, Direction.UP, FORTY_COUNT, FAST_SPEED);
        swipeUp(1, MEDIUM_SPEED);
        return initPage(getDriver(), PlansTaskManagerPageBase.class);
    }

    @Override
    public boolean isSectionSurveyPresent(int timeout) {
        return surveyTitle.isElementPresent(timeout) &&
                whatDoYouThinkTitle.isElementPresent(timeout) &&
                takeTheSurveyTitle.isElementPresent(timeout);
    }

    @Override
    public Point getLocationElement() {
        return takeTheSurveyTitle.getLocation();
    }

}
