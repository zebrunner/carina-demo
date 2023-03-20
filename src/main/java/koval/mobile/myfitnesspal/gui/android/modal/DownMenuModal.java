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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = DownMenuModalBase.class)
public class DownMenuModal extends DownMenuModalBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


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

        if (downMenuIconElement.isElementPresent(TIMEOUT_FIVE)) {
            Assert.fail("Down Menu Element is not present!");
        }

        downMenuIconElement.format(downMenuElement.getPageName().toLowerCase()).click();

        return initPage(getDriver(), downMenuElement.getClassName());
    }


}
