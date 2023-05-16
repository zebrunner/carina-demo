package koval.mobile.myfitnesspal.gui.android.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.myfitnesspal.gui.common.modal.DownMenuModalBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = DownMenuModalBase.class)
public class DownMenuModal extends DownMenuModalBase {

    @FindBy(id = "com.myfitnesspal.android:id/action_%s")
    private ExtendedWebElement downMenuIconElement;


    public DownMenuModal(WebDriver driver) {
        super(driver);
    }

    public DownMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public AbstractPage openPageByName(DownMenuElement downMenuElement) {
        downMenuIconElement.format(downMenuElement.getPageNameForXpath()).click(TIMEOUT_TEN);
        return initPage(getDriver(), downMenuElement.getClassName());
    }

    @Override
    public boolean isMenuElementPresent(DownMenuElement downMenuElement) {
        boolean isElementPresent = downMenuIconElement.format(downMenuElement.getPageNameForXpath()).isElementPresent(TIMEOUT_TEN);
        LOGGER.info("Menu element {} is present: {}", downMenuElement.getPageName(), isElementPresent);
        return isElementPresent;
    }

}
