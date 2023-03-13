package koval.mobile.myfit.gui.ios.modal;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.myfit.gui.common.modal.ManageAccountModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


import java.io.IOException;


@DeviceType(pageType = Type.IOS_PHONE, parentClass = ManageAccountModalBase.class)
public class ManageAccountModal extends ManageAccountModalBase {

    public ManageAccountModal(WebDriver driver) {
        super(driver);
    }

    public ManageAccountModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public int getAccountImageColor() throws IOException {
        throw new NotImplementedException();
    }

}
