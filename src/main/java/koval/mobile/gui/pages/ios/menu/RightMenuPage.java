package koval.mobile.gui.pages.ios.menu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.menu.RightMenuPageBase;
import koval.mobile.gui.pages.service.enums.RightMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import static koval.mobile.gui.pages.service.interfaces.IConstantUtils.TIMEOUT_FIVE;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = RightMenuPageBase.class)
public class RightMenuPage extends RightMenuPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public RightMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRightMenuContainsAllElements() {
        throw new NotImplementedException();
    }

    @Override
    public RightMenuPageBase openMenu() {
        throw new NotImplementedException();
    }

    @Override
    public RightMenuPageBase openPage(RightMenu menu) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isElementPresent(RightMenu menu) {
        throw new NotImplementedException();
    }

}
