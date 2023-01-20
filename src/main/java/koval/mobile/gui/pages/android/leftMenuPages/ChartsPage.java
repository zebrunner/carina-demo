package koval.mobile.gui.pages.android.leftMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.android.menu.LeftMenuModal;
import koval.mobile.gui.pages.common.leftMenuPages.ChartsPageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static koval.mobile.gui.pages.service.interfaces.IConstantUtils.TIMEOUT_FIVE;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private LeftMenuModal leftMenuModal;

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@text='venn chart ']")
    private ExtendedWebElement vennDiagram;

    public ChartsPage(WebDriver driver) {
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
        return title.getText().equals(Menu.CHARTS.getPageName());
    }

    @Override
    public boolean isVennDiagramPresent() {
        return vennDiagram.isElementPresent(TIMEOUT_FIVE);
    }
}
