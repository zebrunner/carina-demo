package koval.mobile.myfitnesspal.gui.common.loginPages;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.service.accountFactory.Account;
import org.openqa.selenium.WebDriver;


public abstract class CreateAccountPageBase extends MyAbstractPage {

    public CreateAccountPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract SignUpPageBase createRandomAccount(Account account);
}
