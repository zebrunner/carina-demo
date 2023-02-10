package koval.carinademo.mobile.gui.ios.menu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;


import koval.carinademo.mobile.gui.common.menu.LeftMenuModalBase;
import koval.carinademo.mobile.service.enums.LeftMenu;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = LeftMenuModalBase.class)
public class LeftMenuModal extends LeftMenuModalBase {

    public LeftMenuModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementPresent(LeftMenu menu) {
        throw new NotImplementedException();
    }

    @Override
    public LeftMenuModalBase openMenu() {
        throw new NotImplementedException();
    }


    @Override
    public AbstractPage openPage(LeftMenu menu) {
        throw new NotImplementedException();
    }


    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

}
