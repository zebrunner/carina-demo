package koval.mobile.gui.pages.ios.menu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;


import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.LeftMenu;
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
