package koval.mobile.myfitnesspal.gui.common.phoneInterface;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.Calories;
import koval.mobile.myfitnesspal.service.enums.WidgetSize;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;


public abstract class PhoneHomePageBase extends MyAbstractPageBase {

    public PhoneHomePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract int getCaloriesValueFromWidget(Calories calories);


    public abstract AbstractPage holdPhoneDesktop();


    public abstract PhoneHomePageBase holdWidget(ExtendedWebElement widget);

    public abstract boolean isSearchButtonPresent(int timeout);

    public abstract boolean isFitnessPalWidgetPresent(int timeout);

    public abstract SearchFoodPageBase pressSearchButton();

    public abstract DashboardPageBase openAppFromWidget();

    public abstract PhoneWidgetPageBase tapWidgetButton();

    public abstract PhoneHomePageBase deleteWidget(String widgetName);

    public abstract PhoneHomePageBase resizeWidgetFromTo(WidgetSize desiredSizeValue, WidgetSize actualSizeValue);

    public abstract PhoneWidgetPageBase searchForApp(String appName);

}
