package koval.mobile.gui.pages.android.leftMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.android.menu.LeftMenuModal;
import koval.mobile.gui.pages.common.leftMenuPages.UIElementsPageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static koval.mobile.gui.pages.service.interfaces.IConstantUtils.TIMEOUT_FIVE;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "com.solvd.carinademoapplication:id/imageView")
    private ExtendedWebElement profileImage;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(Menu.UI_ELEMENTS.getPageName());
    }

    @Override
    public boolean isProfileImagePresent() {
        return profileImage.isElementPresent(TIMEOUT_FIVE);
    }
}
