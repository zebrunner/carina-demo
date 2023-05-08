package koval.mobile.myfitnesspal.gui.ios.modal;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.gui.common.modal.MePageMenuModalBase;
import koval.mobile.myfitnesspal.service.enums.MePageMenuTab;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = MePageMenuModalBase.class)
public class MePageMenuModal extends MePageMenuModalBase {

    public MePageMenuModal(WebDriver driver) {
        super(driver);
    }

    public MePageMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public MePageBase openTabByName(MePageMenuTab mePageMenuTab) {
        throw new NotImplementedException();
    }


}
