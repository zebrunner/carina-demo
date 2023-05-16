package koval.mobile.myfitnesspal.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.carinademo.gui.common.loginPages.LoginPageBase;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.MorePageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MorePageBase.class)
public class MorePage extends MorePageBase {


    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    public MorePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }

    @Override
    public LoginPageBase clickLogout() {

        ExtendedWebElement logOut = itemByText.format(LOG_OUT);

        swipe(logOut, Direction.UP, TWENTY_COUNT, MEDIUM_SPEED);
        swipeUp(1, MEDIUM_SPEED);
        logOut.click(TIMEOUT_TEN);

        itemByText.format(YES_ANSWER).click(TIMEOUT_TEN);
        return initPage(getDriver(), LoginPageBase.class);

    }
}
