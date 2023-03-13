package koval.mobile.carinademo.gui.ios.leftMenuPages;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.carinademo.gui.common.leftMenuPages.UIElementsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {
    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProfileImagePresent(long timeOut) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }


}
