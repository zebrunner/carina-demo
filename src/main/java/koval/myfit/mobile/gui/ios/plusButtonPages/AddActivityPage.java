package koval.myfit.mobile.gui.ios.plusButtonPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.modal.DatePickerModalBase;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
import koval.myfit.mobile.gui.common.plusButtonPages.AddActivityPageBase;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddActivityPageBase.class)
public class AddActivityPage extends AddActivityPageBase {


    public AddActivityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TimePickerModalBase setTime(Calendar calendar) {
        throw new NotImplementedException();
    }

    @Override
    public AddActivityPageBase setDuration(Calendar calendar) {
        throw new NotImplementedException();
    }

    @Override
    public DatePickerModalBase setDate(Calendar calendar) {
        throw new NotImplementedException();
    }

    @Override
    public String selectActivity(String activity) {
        throw new NotImplementedException();
    }

    @Override
    public String selectRandomActivity() {
        throw new NotImplementedException();
    }

    @Override
    public HomePageBase saveActivity() {
        throw new NotImplementedException();
    }

}
