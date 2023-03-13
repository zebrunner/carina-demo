package koval.mobile.myfit.gui.common.aboutMePages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class HeightPageBase extends MyAbstractPage {

    public HeightPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract HeightPageBase setHeight(int centimeters );


    public abstract HeightPageBase setHeight(float feetInch );

    public abstract HeightPageBase setHeight(int heightValue, float actualHeight, String measure, ExtendedWebElement heightContainer);

    public abstract HeightPageBase setHeightMeasure(String measure);
}
