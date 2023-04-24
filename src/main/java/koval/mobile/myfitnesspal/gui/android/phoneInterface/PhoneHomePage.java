package koval.mobile.myfitnesspal.gui.android.phoneInterface;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneWidgetPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.Calories;
import koval.mobile.myfitnesspal.service.enums.WidgetSize;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PhoneHomePageBase.class)
public class PhoneHomePage extends PhoneHomePageBase {

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//*[@content-desc='%s']")
    private ExtendedWebElement itemByContent;

    @FindBy(xpath = "//com.android.launcher3.widget.LauncherAppWidgetHostView[@content-desc=\"MyFitnessPal\"]")
    private ExtendedWebElement fitnessPalWidgetItem;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/widget_resize_frame")
    private ExtendedWebElement resizeWidgetFrame;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/widget_resize_%s_handle")
    private ExtendedWebElement resizeHandlePoint;

    @FindBy(id = "com.myfitnesspal.android:id/imageWidgetCaloriesSearch")
    private ExtendedWebElement widgetCaloriesSearchImage;


    @FindBy(id = "com.myfitnesspal.android:id/textCalories%sCount")
    private ExtendedWebElement caloriesCount;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/widgets_search_bar_edit_text")
    private ExtendedWebElement searchWidgetField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.nexuslauncher:id/app_title' and @text='%s']")
    private ExtendedWebElement appTitle;

    @FindBy(xpath = "//*[@text='%s']/parent::*/*[@resource-id='com.google.android.apps.nexuslauncher:id/widget_preview_container']")
    private ExtendedWebElement widgetContainer;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public PhoneHomePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public int getCaloriesValueFromWidget(Calories calories) {

        String caloriesType = calories.getCaloriesType();
        if (!caloriesCount.format(caloriesType).isElementPresent(TIMEOUT_TEN)) {
            Assert.fail(String.format("[ PHONE HOME PAGE] There is no %s Calories Count element", caloriesType));
        }

        int caloriesCountValue = Integer.parseInt(caloriesCount.format(caloriesType).getText().replaceAll(COMMA_VALUE, ""));
        LOGGER.info("{} Calories count value: {}", caloriesType, caloriesCountValue);

        return caloriesCountValue;
    }


    public AbstractPage holdElement(ExtendedWebElement extendedWebElement, Class<? extends AbstractPage> className) {
        longTap(extendedWebElement);
        return initPage(getDriver(), className);
    }

    public AbstractPage tapElement(ExtendedWebElement extendedWebElement, Class<? extends AbstractPage> className) {

        extendedWebElement.click();
        return initPage(getDriver(), className);
    }

    @Override
    public PhoneHomePageBase holdPhoneDesktop() {
        return (PhoneHomePageBase) holdElement(itemByContent.format(HOME_STRING), PhoneHomePageBase.class);
    }


    @Override
    public PhoneHomePageBase holdWidget(ExtendedWebElement widget) {
        return (PhoneHomePageBase) holdElement(widget, PhoneHomePageBase.class);
    }


    @Override
    public boolean isSearchButtonPresent(int timeout) {
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(itemByText.format(LOADING).getBy()), TIMEOUT_TWENTY);

        return widgetCaloriesSearchImage.isElementPresent(timeout);
    }


    @Override
    public boolean isFitnessPalWidgetPresent(int timeout) {
        pressKey(BACK);
        return fitnessPalWidgetItem.isElementPresent(timeout);
    }


    @Override
    public SearchFoodPageBase pressSearchButton() {

        if (!fitnessPalWidgetItem.isElementPresent(TIMEOUT_TEN)) {
            pressKey(BACK);
        }

        return (SearchFoodPageBase) tapElement(widgetCaloriesSearchImage, SearchFoodPageBase.class);
    }

    @Override
    public DashboardPageBase openAppFromWidget() {

        if (!fitnessPalWidgetItem.isElementPresent(TIMEOUT_TEN)) {
            pressKey(BACK);
        }

        return (DashboardPageBase) tapElement(fitnessPalWidgetItem, DashboardPageBase.class);
    }


    @Override
    public PhoneWidgetPageBase tapWidgetButton() {
        return (PhoneWidgetPageBase) tapElement(itemByText.format(WIDGETS_STRING), PhoneWidgetPageBase.class);

    }

    @Override
    public PhoneHomePageBase deleteWidget(String widgetName) {

        if (!resizeWidgetFrame.isElementPresent(TIMEOUT_TEN)) {
            holdWidget(itemByContent.format(widgetName));
        }

        int attemp = 3;
        int desiredY = adbService.getScreenPhysicalDensity();
        while (resizeWidgetFrame.isElementPresent(TIMEOUT_FIFTEEN) && attemp > 0) {
            int centerX = getCenterX(resizeWidgetFrame);
            int centerY = getCenterY(resizeWidgetFrame);

            String deviceDisplaySizeByX = adbService.getDeviceDisplaySize().substring(0, adbService.getDeviceDisplaySize().indexOf('x'));
            int desiredX = Integer.parseInt(deviceDisplaySizeByX.replaceAll(NUMBERS_ONLY, EMPTY_FIELD)) / 2;

            adbService.swipeElementByCoordinates(centerX, centerY, desiredX, desiredY);

            desiredY -= 100;
            attemp--;

        }

        return initPage(getDriver(), PhoneHomePageBase.class);
    }

    @Override
    public PhoneHomePageBase resizeWidgetFromTo(WidgetSize actualSizeValue, WidgetSize desiredSizeValue) {

        if (!resizeWidgetFrame.isElementPresent(TIMEOUT_TEN)) {
            holdWidget(fitnessPalWidgetItem);
        }

        int widgetWidth = resizeWidgetFrame.getSize().getWidth();
        int widgetHeight = resizeWidgetFrame.getSize().getHeight();

        int topX = resizeWidgetFrame.getLocation().getX();
        int topY = resizeWidgetFrame.getLocation().getY();

        int startBottomX = topX + widgetWidth;
        int startBottomY = topY + widgetHeight;

        int endX = topX + (desiredSizeValue.getFirstValue() * (widgetWidth / actualSizeValue.getFirstValue()));
        int endY = topY + (desiredSizeValue.getSecondValue() * (widgetHeight / actualSizeValue.getSecondValue()));


        swipe(startBottomX, startBottomY, endX, endY, MEDIUM_SPEED);

        pressKey(BACK);

        return initPage(getDriver(), PhoneHomePageBase.class);
    }


    @Override
    public boolean isPageOpened() {
        return isPageOpened(TIMEOUT_FIFTEEN);
    }

    @Override
    public PhoneWidgetPageBase searchForApp(String appName) {

        searchWidgetField.type(appName);

        appTitle.format(appName).click();

        return initPage(getDriver(), PhoneWidgetPageBase.class);
    }

//    @Override
//    public PhoneWidgetPageBase addWidgetToDesktop(String widgetName) {
//
//        int centerX = getCenterX(widgetContainer.format(widgetName));
//
//        int centerY = getCenterY(widgetContainer.format(widgetName));
//        int upperY = (centerY - widgetContainer.format(widgetName).getLocation().getY()) / 2;
//        int desiredY = centerY - upperY;
//
//        adbService.holdElementByCoordinates(centerX, desiredY);
//
//        if (!isFitnessPalWidgetPresent(TIMEOUT_FIFTEEN)) {
//            Assert.fail("[ PHONE HOME PAGE ] '%s' widget is not added! App name '%s'\", FITNESSPAL, CALORIES_WIDGET)");
//        }
//
//        return initPage(getDriver(), PhoneWidgetPageBase.class);
//    }

}
