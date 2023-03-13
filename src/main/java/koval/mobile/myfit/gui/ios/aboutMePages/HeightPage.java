package koval.mobile.myfit.gui.ios.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.aboutMePages.HeightPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HeightPageBase.class)
public class HeightPage extends HeightPageBase {


    public HeightPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeightPageBase setHeight(int centimeters) {
        throw new NotImplementedException();
    }

    @Override
    public HeightPageBase setHeight(float feetInch) {
        throw new NotImplementedException();
    }

    @Override
    public HeightPageBase setHeight(int heightValue, float actualHeight, String measure, ExtendedWebElement heightContainer) {
        throw new NotImplementedException();
    }

    @Override
    public HeightPageBase setHeightMeasure(String measure) {
        throw new NotImplementedException();
    }

}
