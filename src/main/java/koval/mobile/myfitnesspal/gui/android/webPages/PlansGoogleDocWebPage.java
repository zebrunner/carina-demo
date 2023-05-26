package koval.mobile.myfitnesspal.gui.android.webPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansGoogleDocWebPageBase.class)
public class PlansGoogleDocWebPage extends PlansGoogleDocWebPageBase {

    @FindBy(id = "com.android.chrome:id/url_bar")
    private ExtendedWebElement urlBar;

    public PlansGoogleDocWebPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened(int timeout, String url) {
        return itemByText.format(PLANS_SURVEY_TITLE).isElementPresent(timeout) && urlBar.getText().equals(url);
    }


    @Override
    public PlansGoogleDocWebPageBase closeChromeStopsWorkingPopUpIfPresent() {

        itemByText.format("Close app").clickIfPresent();
        return initPage(getDriver(), PlansGoogleDocWebPageBase.class);

    }

}
