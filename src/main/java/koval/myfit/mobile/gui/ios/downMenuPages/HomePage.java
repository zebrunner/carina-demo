package koval.myfit.mobile.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.menu.PlusButtonModalBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.MaterialCardTopics;
import org.openqa.selenium.WebDriver;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public WelcomePageBase signOut() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPageByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }


    @Override
    public boolean isPlusBtnStatic() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlusBtnOverElements() {
        throw new NotImplementedException();
    }

    @Override
    public HomePageBase closePlusButtonMenu() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlusButtonBelowBlockContainer() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBlockByTitlePresent(MaterialCardTopics topic) {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getPlaylistTitlesToList() {
        throw new NotImplementedException();
    }

}
