package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.android.menu.LeftMenuModal;
import koval.mobile.gui.pages.common.leftMenuPages.PageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class BasePage extends PageBase {


    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private LeftMenuModal leftMenuModal;

    public BasePage(WebDriver driver) {
        super(driver);
    }


    public LeftMenuModalBase openMenu() {
        leftMenuModal.openMenu();
        return initPage(getDriver(), LeftMenuModalBase.class);
    }


    public AbstractPage openPage(Menu menu) {
        return leftMenuModal.openPage(menu);
    }

    public boolean isMenuElementPresent(Menu menu) {
        return leftMenuModal.isElementPresent(menu);
    }
}
