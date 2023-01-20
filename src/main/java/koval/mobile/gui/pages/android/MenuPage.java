package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gui.pages.android.menu.LeftMenuModal;
import koval.mobile.gui.pages.common.leftMenuPages.MenuPageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {


    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private LeftMenuModal leftMenuModal;

    public MenuPage(WebDriver driver) {
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
}
