package koval.mobile.gui.pages.ios.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.leftMenuPages.MapPageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LeftMenuModalBase openMenu() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPage(Menu menu) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isMenuElementPresent(Menu menu) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isMapImagePresent() {
        throw new NotImplementedException();
    }
}
