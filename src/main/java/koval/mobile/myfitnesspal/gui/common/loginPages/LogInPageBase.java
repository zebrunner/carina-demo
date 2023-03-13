package koval.mobile.myfitnesspal.gui.common.loginPages;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class LogInPageBase extends MyAbstractPage {

    public LogInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract LogInPageBase typeMail(String password);

    public abstract LogInPageBase typePassword(String password);

    public abstract LogInPageBase clickLoginButton();
}
