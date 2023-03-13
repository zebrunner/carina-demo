package koval.mobile.myfit.gui.ios.plusButtonPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.downMenuPages.HomePageBase;
import koval.mobile.myfit.gui.common.modal.TimePickerModalBase;
import koval.mobile.myfit.gui.common.plusButtonPages.AddActivityPageBase;
import koval.mobile.myfit.gui.common.plusButtonPages.AddBloodPressurePageBase;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddBloodPressurePageBase.class)
public class AddBloodPressureTest extends AddBloodPressurePageBase {


    public AddBloodPressureTest(WebDriver driver) {
        super(driver);
    }

    @Override
    public TimePickerModalBase setTime(Calendar calendar) {
        throw new NotImplementedException();
    }

    @Override
    public AddActivityPageBase setBloodPressure(int topNumberBloodPressure, int bottomNumberBloodPressure) {
        throw new NotImplementedException();
    }

    @Override
    public AddBloodPressurePageBase setBloodPressure(int bloodPressureNumber, ExtendedWebElement bloodPressureContainer, ExtendedWebElement bloodPressureElement) {
        throw new NotImplementedException();
    }

    @Override
    public HomePageBase saveBloodPressure() {
        throw new NotImplementedException();
    }
}
