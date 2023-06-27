package koval.mobile.myfitnesspal.gui.common.loginPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import org.openqa.selenium.WebDriver;


public abstract class WelcomePageBase extends MyAbstractPageBase {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract SignUpPageBase signUp();

    public abstract LogInPageBase logIn();

    public abstract AbstractPage clickButton(String buttonText);
}
