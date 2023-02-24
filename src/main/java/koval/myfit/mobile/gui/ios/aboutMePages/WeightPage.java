package koval.myfit.mobile.gui.ios.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.WeightPageBase;
import koval.myfit.mobile.service.enums.WeightMeasures;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WeightPageBase.class)
public class WeightPage extends WeightPageBase {


    public WeightPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WeightPageBase setWeight(float weight, WeightMeasures measure) {
        throw new NotImplementedException();
    }

    @Override
    public WeightPageBase setWeight(int weightValue, float actualWeight, String measure, ExtendedWebElement weightContainer) {
        throw new NotImplementedException();
    }

    @Override
    public WeightPageBase setWeightMeasure(String measure) {
        throw new NotImplementedException();
    }


}
