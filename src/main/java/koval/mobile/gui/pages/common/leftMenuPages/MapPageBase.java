package koval.mobile.gui.pages.common.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;

public abstract class MapPageBase extends AbstractPage {

    public MapPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LeftMenuModalBase openMenu();

    public abstract AbstractPage openPage(Menu menu);

    public abstract boolean isMenuElementPresent(Menu menu);

    public abstract boolean isMapImagePresent();
}
