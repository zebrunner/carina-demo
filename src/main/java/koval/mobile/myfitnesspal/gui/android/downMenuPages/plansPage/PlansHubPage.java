package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Filters;
import koval.mobile.myfitnesspal.service.enums.PlansCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansHubPageBase.class)
public class PlansHubPage extends PlansHubPageBase {


    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android.plans:id/plans_segment_header' and @text='%s']//following-sibling::*//android.view.ViewGroup")
    private ExtendedWebElement planByCategory;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android.plans:id/chipGroupFilterTags']/child::*[@text='%s']")
    private ExtendedWebElement filterTagButton;

    @FindBy(id = "com.myfitnesspal.android.plans:id/hubRecyclerView")
    private ExtendedWebElement plansContainer;

    @FindBy(id = "com.myfitnesspal.android.plans:id/planSurveyTitle")
    private ExtendedWebElement surveyTitle;

    @FindBy(id = "com.myfitnesspal.android.plans:id/what_do_you_think")
    private ExtendedWebElement whatDoYouThinkTitle;

    @FindBy(id = "com.myfitnesspal.android.plans:id/take_the_survey")
    private ExtendedWebElement takeTheSurveyTitle;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/toolbar']/child::*[@class='android.widget.TextView']")
    private ExtendedWebElement title;

    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private ExtendedWebElement backButton;

    public PlansHubPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        return isPageOpened(title, DownMenuElement.PLANS.getPageName(), timeout) &&
                itemByText.format(FIND_PLAN).isElementPresent(TIMEOUT_TEN);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        return downMenuModal.openPageByName(downMenuElement);
    }


    @Override
    public PlansDetailsPageBase clickOnAvailablePlan(Filters filters) {
        filterTagButton.format(filters.getFilters()).click(TIMEOUT_FIFTEEN);
        planByCategory.format(PlansCategory.AVAILABLE_PLANS.getPlanCategory()).click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansDetailsPageBase.class);
    }

    @Override
    public boolean isCurrentActivePlanDisplayed(String currentPlanTitle) {
        LOGGER.info("[ PLANS HUB PAGE ] expected Plan Title is {}", currentPlanTitle);
        String activePlanTitle = planByCategory.format(PlansCategory.ACTIVE_PLANS.getPlanCategory()).
                findExtendedWebElement(By.id("com.myfitnesspal.android.plans:id/plan_name")).getAttribute(TEXT);
        LOGGER.info("[ PLANS HUB PAGE ] current Plan Title is {}", activePlanTitle);
        return activePlanTitle.equals(currentPlanTitle);
    }


    public int getActivePlanBlockHeight() {
        int blockHeight = planByCategory.format(PlansCategory.ACTIVE_PLANS.getPlanCategory()).getSize().height; //637
        LOGGER.info("[ PLANS HUB PAGE ] height of active plan block is {}", blockHeight);
        return blockHeight;
    }


    public int getActivePlanBlockByY() {
        int blockY = planByCategory.format(PlansCategory.ACTIVE_PLANS.getPlanCategory()).getLocation().getY() + getActivePlanBlockHeight();//1253
        LOGGER.info("[ PLANS HUB PAGE ] Y value of active plan block is {}", blockY);
        return blockY;
    }


    @Override
    public boolean isActivePlanDisplayOnlyJoinedPlan() {
        return getPlanCategoryByY(PlansCategory.AVAILABLE_PLANS) - getPlanCategoryByY(PlansCategory.ACTIVE_PLANS) < getActivePlanBlockHeight() * 2;
    }


    public int getPlanCategoryByY(PlansCategory plansCategory) {
        int categoryByY = itemByText.format(plansCategory.getPlanCategory()).getLocation().getY();
        LOGGER.info("[ PLANS HUB PAGE ] Y value of category {} plan block is {}", plansCategory.getPlanCategory(), categoryByY);
        return categoryByY;
    }


    @Override
    public PlansGoogleDocWebPageBase clickTakeSurvey() {
        itemByText.format(TAKE_SURVEY).click(TIMEOUT_TEN);
        itemByText.format(ACCEPT_CONTINUE).clickIfPresent(TIMEOUT_TEN);
        itemByText.format(NO_THANKS).clickIfPresent(TIMEOUT_TEN);
        itemByText.format(NO_THANKS_ANSWER).clickIfPresent(TIMEOUT_TEN);
        return initPage(getDriver(), PlansGoogleDocWebPageBase.class);

    }

    @Override
    public PlansTaskManagerPageBase clickBackButton() {
        backButton.click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansTaskManagerPageBase.class);
    }

    @Override
    public PlansHubPageBase swipeToSurveyTitle(int timeout) {
        swipe(takeTheSurveyTitle, plansContainer, Direction.UP, FORTY_COUNT, FAST_SPEED);
        swipeUp(1, MEDIUM_SPEED);
        return initPage(getDriver(), PlansHubPageBase.class);
    }

    @Override
    public boolean isSectionSurveyPresent(int timeout) {
        return surveyTitle.isElementPresent(timeout) &&
                whatDoYouThinkTitle.isElementPresent(timeout) &&
                takeTheSurveyTitle.isElementPresent(timeout);
    }

    @Override
    public boolean isSurveyTitleAtTheBottom() {
        Point point = getLocationElement();
        swipeUp(1, MEDIUM_SPEED);
        return getLocationElement().getY() == point.getY();
    }


    public Point getLocationElement() {
        return takeTheSurveyTitle.getLocation();
    }

}
