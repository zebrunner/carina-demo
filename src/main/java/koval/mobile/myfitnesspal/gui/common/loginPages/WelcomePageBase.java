package koval.mobile.myfitnesspal.gui.common.loginPages;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class WelcomePageBase extends MyAbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();


    public abstract WelcomePageBase notificationSendPopUpIfPresent(String answer);

    public abstract SignUpPageBase signUp();

    public abstract LogInPageBase logIn();
}
