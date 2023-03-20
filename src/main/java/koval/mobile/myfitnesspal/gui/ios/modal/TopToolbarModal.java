package koval.mobile.myfitnesspal.gui.ios.modal;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.gui.common.modal.TopToolbarModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = Type.IOS_PHONE, parentClass = TopToolbarModalBase.class)
public class TopToolbarModal extends TopToolbarModalBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public TopToolbarModal(WebDriver driver) {
        super(driver);
    }

    public TopToolbarModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isPageOpened(String textTitle) {
        throw new NotImplementedException();
    }

    @Override
    public String getTitleText() {
        throw new NotImplementedException();
    }

    @Override
    public WelcomePageBase clickReturnBackButton() {
        throw new NotImplementedException();
    }


}
