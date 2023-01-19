package koval.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.CarinaDescriptionPageBase;

import koval.mobile.gui.pages.service.enums.Tab;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = CarinaDescriptionPageBase.class)
public class CarinaDescriptionPage extends CarinaDescriptionPageBase {

    public CarinaDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementPresent() {
        throw new NotImplementedException();
    }

    @Override
    public CarinaDescriptionPageBase clickOnBurgerMenu() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSelectedElementPresent(Tab tab) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage clickOnTab(Tab tab) {
        return null;
    }


    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

}
