package koval.mobile.myfitnesspal.gui.ios.webPages;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlansGoogleDocWebPageBase.class)
public class PlansGoogleDocWebPage extends PlansGoogleDocWebPageBase {

    public PlansGoogleDocWebPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout, String url) {
        throw new NotImplementedException();
    }


}
