package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.TopToolbarModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/toolbar")
    private TopToolbarModal topToolbarModal;

    @FindBy(xpath = "//android.widget.Button[@text='%s']")
    private ExtendedWebElement buttonByText;

    @FindBy(xpath = "//*[@resource-id='buttonExistingUserTutorial']/child::*[@class='android.widget.Button']")
    private ExtendedWebElement exitTutorialButton;

    @FindBy(id = "com.myfitnesspal.android:id/password_edit")
    private ExtendedWebElement passwordField;

    @FindBy(id = "com.myfitnesspal.android:id/email_address_edit")
    private ExtendedWebElement mailField;

    public LogInPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return topToolbarModal.isPageOpened(LOGIN);
    }

    @Override
    public LogInPageBase typeMail(String password) {
        mailField.type(password, TIMEOUT_FIVE);
        return initPage(getDriver(), LogInPageBase.class);
    }


    @Override
    public LogInPageBase typePassword(String password) {
        passwordField.type(password, TIMEOUT_FIVE);
        return initPage(getDriver(), LogInPageBase.class);
    }


    @Override
    public DashboardPageBase clickLoginButton() {
        buttonByText.format(LOGIN).click(TIMEOUT_TEN);
        return initPage(getDriver(), DashboardPageBase.class);

    }

}
