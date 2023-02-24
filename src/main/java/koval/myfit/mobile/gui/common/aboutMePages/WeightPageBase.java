package koval.myfit.mobile.gui.common.aboutMePages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.service.enums.WeightMeasures;
import org.openqa.selenium.WebDriver;


public abstract class WeightPageBase extends MyAbstractPage {

    public WeightPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WeightPageBase setWeight(float weight, WeightMeasures measure);

    public abstract WeightPageBase setWeight(int weightValue, float actualWeight, String measure, ExtendedWebElement weightContainer);

    public abstract WeightPageBase setWeightMeasure(String measure);
}
