package koval.myfit.mobile.gui.ios.modal;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.myfit.mobile.gui.common.modal.DatePickerModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


@DeviceType(pageType = Type.IOS_PHONE, parentClass = DatePickerModalBase.class)
public class DatePickerModal extends DatePickerModalBase {


    public DatePickerModal(WebDriver driver) {
        super(driver);
    }

    public DatePickerModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public DatePickerModalBase setDate(Calendar calendar) {
        throw new NotImplementedException();
    }


}
