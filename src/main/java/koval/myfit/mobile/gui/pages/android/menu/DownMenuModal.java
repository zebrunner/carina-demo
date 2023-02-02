package koval.myfit.mobile.gui.pages.android.menu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.carinademo.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.myfit.mobile.gui.pages.common.menu.DownMenuModalBase;
import koval.myfit.mobile.gui.pages.service.enums.DownMenuElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = DownMenuModalBase.class)
public class DownMenuModal extends DownMenuModalBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "com.google.android.apps.fitness:id/bottom_navigation")
    private List<ExtendedWebElement> listOfMenuElement;

    public DownMenuModal(WebDriver driver) {
        super(driver);
    }

    public DownMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public AbstractPage openPageByName(DownMenuElement downMenuElement) {

        if (listOfMenuElement.isEmpty()) {
            Assert.fail("d");
        }

        listOfMenuElement.get(downMenuElement.getPageIndex()).click();

        return initPage(getDriver(), downMenuElement.getClassName());
    }
}
