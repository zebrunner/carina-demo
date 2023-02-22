package koval.myfit.mobile.gui.common.plusButtonPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


public abstract class AddBloodPressurePageBase extends MyAbstractPage {

    public AddBloodPressurePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TimePickerModalBase setTime(Calendar calendar);


    public abstract AddActivityPageBase setBloodPressure(int topNumberBloodPressure, int bottomNumberBloodPressure);

    public abstract AddBloodPressurePageBase setBloodPressure(int bloodPressureNumber, ExtendedWebElement bloodPressureContainer, ExtendedWebElement bloodPressureElement);


    public abstract HomePageBase saveBloodPressure();
}
