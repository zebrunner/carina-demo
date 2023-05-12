package koval.mobile.myfitnesspal.gui.ios.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.myfitnesspal.gui.common.modal.DownMenuModalBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = Type.IOS_PHONE, parentClass = DownMenuModalBase.class)
public class DownMenuModal extends DownMenuModalBase {


    public DownMenuModal(WebDriver driver) {
        super(driver);
    }

    public DownMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AbstractPage openPageByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isMenuElementPresent(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }
}
