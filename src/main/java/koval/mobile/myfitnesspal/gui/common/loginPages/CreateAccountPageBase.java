package koval.mobile.myfitnesspal.gui.common.loginPages;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.service.factories.accountFactory.Account;
import org.openqa.selenium.WebDriver;


public abstract class CreateAccountPageBase extends MyAbstractPageBase {

    public CreateAccountPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract SignUpPageBase createRandomAccount(Account account);
}
