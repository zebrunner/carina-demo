package koval.mobile.myfitnesspal.gui.android.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.gui.common.modal.TopToolbarModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = TopToolbarModalBase.class)
public class TopToolbarModal extends TopToolbarModalBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    private ExtendedWebElement returnBackButton;


    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/toolbar']/child::*[@class='android.widget.TextView']")
    private ExtendedWebElement title;

    public TopToolbarModal(WebDriver driver) {
        super(driver);
    }

    public TopToolbarModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isPageOpened(String textTitle) {
        return isPageOpened(title, textTitle);
    }

    @Override
    public String getTitleText() {

        if (!title.isElementPresent(TIMEOUT_FIVE)) {
            Assert.fail("[ TOP TOOLBAR  ] Title is not present!");
        }

        return title.getText();
    }

    @Override
    public WelcomePageBase clickReturnBackButton() {
        returnBackButton.click();
        return initPage(getDriver(), WelcomePageBase.class);
    }


}
