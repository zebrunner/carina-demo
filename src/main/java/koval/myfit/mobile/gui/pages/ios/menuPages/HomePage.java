package koval.myfit.mobile.gui.pages.ios.menuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.pages.common.menuPages.HomePageBase;
import koval.myfit.mobile.gui.pages.service.enums.DownMenuElement;
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
    public AbstractPage open(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getPlusButtonMenuElementsToList() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlusButtonOverOtherElements() {
        throw new NotImplementedException();
    }


    @Override
    public boolean isPlusBtnStatic() {
        throw new NotImplementedException();
    }

    @Override
    public int getContainerHeight() {
        throw new NotImplementedException();
    }


    @Override
    public List<String> getMaterialCardTopicsToList() {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getPlaylistTitlesToList() {
        throw new NotImplementedException();
    }

}
