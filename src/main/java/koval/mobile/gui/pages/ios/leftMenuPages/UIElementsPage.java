package koval.mobile.gui.pages.ios.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.leftMenuPages.UIElementsPageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.LeftMenu;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {
    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProfileImagePresent(long timeOut) {
        return false;
    }


    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }


}
