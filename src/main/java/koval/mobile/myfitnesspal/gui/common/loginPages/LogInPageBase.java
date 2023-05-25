package koval.mobile.myfitnesspal.gui.common.loginPages;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import org.openqa.selenium.WebDriver;


public abstract class LogInPageBase extends MyAbstractPageBase {

    public LogInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract LogInPageBase typeMail(String password);

    public abstract LogInPageBase clickOnLoginFailed();

    public abstract LogInPageBase typePassword(String password);

    public abstract LogInPageBase clickLoginButton();

    public abstract DashboardPageBase closeNoSubscriptionsPopUpIfPresent();

    public abstract void closeUserTutorialBoxIfPresent();
}
