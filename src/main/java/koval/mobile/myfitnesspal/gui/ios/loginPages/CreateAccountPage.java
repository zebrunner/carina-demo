package koval.mobile.myfitnesspal.gui.ios.loginPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.loginPages.CreateAccountPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.service.factories.accountFactory.Account;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CreateAccountPageBase.class)
public class CreateAccountPage extends CreateAccountPageBase {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignUpPageBase createRandomAccount(Account account) {
        throw new NotImplementedException();
    }


}
