package koval.mobile.gui.pages.android.leftMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.android.menu.LeftMenuModal;
import koval.mobile.gui.pages.common.leftMenuPages.MapPageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static koval.mobile.gui.pages.service.interfaces.IConstantUtils.TIMEOUT_FIVE;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.RelativeLayout[@index='2']")
    private ExtendedWebElement mapImage;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private LeftMenuModal leftMenuModal;

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LeftMenuModalBase openMenu() {
        leftMenuModal.openMenu();
        return initPage(getDriver(), LeftMenuModalBase.class);
    }

    @Override
    public AbstractPage openPage(Menu menu) {
        return leftMenuModal.openPage(menu);
    }

    @Override
    public boolean isMenuElementPresent(Menu menu) {
        return leftMenuModal.isElementPresent(menu);
    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(Menu.MAP.getPageName());
    }

    @Override
    public boolean isMapImagePresent() {
        return mapImage.isElementPresent(TIMEOUT_FIVE);
    }
}
