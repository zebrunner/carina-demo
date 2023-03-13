package koval.mobile.myfit.gui.ios.browsePages;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.browsePages.VitalsPageBase;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = VitalsPageBase.class)
public class VitalsPage extends VitalsPageBase {
    public VitalsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public int getTopNumberBloodPressure() {
        throw new NotImplementedException();
    }

    @Override
    public int getBottomNumberBloodPressure() {
        throw new NotImplementedException();
    }
}
