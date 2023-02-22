package koval.myfit.mobile.gui.ios.modal;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = TimePickerModalBase.class)
public class TimePickerModal extends TimePickerModalBase {


    public TimePickerModal(WebDriver driver) {
        super(driver);
    }

    public TimePickerModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public TimePickerModalBase setTime(Calendar calendar) {
        throw new NotImplementedException();
    }


}
