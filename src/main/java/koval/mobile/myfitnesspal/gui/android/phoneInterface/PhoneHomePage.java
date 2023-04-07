package koval.mobile.myfitnesspal.gui.android.phoneInterface;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneWidgetPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PhoneHomePageBase.class)
public class PhoneHomePage extends PhoneHomePageBase {

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//*[@content-desc='%s']")
    private ExtendedWebElement itemByContent;

    @FindBy(id = "com.myfitnesspal.android:id/layoutWidgetCalories")
    private ExtendedWebElement fitnessPalWidgetItem;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/widget_resize_frame")
    private ExtendedWebElement resizeWidgetFrame;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/widget_resize_right_handle")
    private ExtendedWebElement rightResizeHandle;

    @FindBy(id = "com.myfitnesspal.android:id/imageWidgetCaloriesSearch")
    private ExtendedWebElement widgetCaloriesSearchImage;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public PhoneHomePage(WebDriver driver) {
        super(driver);
    }


    public AbstractPage holdElement(ExtendedWebElement extendedWebElement, Class<? extends AbstractPage> className) {

        int centerX = getCenterX(extendedWebElement);
        int centerY = getCenterY(extendedWebElement);

        adbService.holdElementByCoordinates(centerX, centerY);

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

        return (SearchFoodPageBase) tapElement(widgetCaloriesSearchImage, SearchFoodPageBase.class);
    }


    @Override
    public PhoneWidgetPageBase tapWidgetButton() {
        return (PhoneWidgetPageBase) tapElement(itemByText.format(WIDGETS_STRING), PhoneWidgetPageBase.class);

    }


    @Override
    public PhoneHomePageBase deleteWidget(String widgetName) {

        holdWidget(itemByContent.format(widgetName));


        int attemp = 3;
            while (resizeWidgetFrame.isElementPresent(TIMEOUT_FIFTEEN)  && attemp > 0 ) {
                int centerX = getCenterX(resizeWidgetFrame);
                int centerY = getCenterY(resizeWidgetFrame);

                int desiredY = centerY - SCREEN_PHYSICAL_DENSITY;

                swipe(centerX, centerY, centerX, desiredY, LOW_SPEED);

                attemp--;
            }

            return initPage(getDriver(), PhoneHomePageBase.class);
        }

        @Override
        public PhoneHomePageBase resizeWidgetByX ( int sizeValue){

            holdWidget(fitnessPalWidgetItem);
            int centerX = getCenterX(rightResizeHandle);
            int centerY = getCenterY(rightResizeHandle);

            LOGGER.info("Screen Physical Density is: {}", SCREEN_PHYSICAL_DENSITY);

            int desiredX = sizeValue * SCREEN_PHYSICAL_DENSITY;

            swipe(centerX, centerY, desiredX, centerY, MEDIUM_SPEED);

            pressKey(BACK);

            return initPage(getDriver(), PhoneHomePageBase.class);
        }

    }
