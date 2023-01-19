package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.ChartsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;


    @FindBy(xpath = "//*[@text='venn chart ']")
    private ExtendedWebElement vennChart;

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public boolean isVennChartPresent() {
        return vennChart.isElementPresent();
    }
}
