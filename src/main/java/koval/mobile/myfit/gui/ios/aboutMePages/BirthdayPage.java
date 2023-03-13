package koval.mobile.myfit.gui.ios.aboutMePages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.aboutMePages.BirthdayPageBase;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BirthdayPageBase.class)
public class BirthdayPage extends BirthdayPageBase {

    public BirthdayPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BirthdayPageBase setDate(Calendar calendar) {
        throw new NotImplementedException();
    }

    @Override
    public BirthdayPageBase saveChanges() {
        throw new NotImplementedException();
    }

    @Override
    public BirthdayPageBase returnBack() {
        throw new NotImplementedException();
    }

}
