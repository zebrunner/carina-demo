package koval.myfit.mobile.gui.common.downMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.MaterialCardTopics;
import koval.myfit.mobile.service.enums.PlusButtonMenuElement;
import org.openqa.selenium.WebDriver;

import java.util.List;


public abstract class HomePageBase extends MyAbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract WelcomePageBase signOut();


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);

    public abstract boolean isPlusBtnStatic();

    public abstract boolean isPlusBtnOverElements();

    public abstract AbstractPage openPageFromPlusButtonMenuByName(PlusButtonMenuElement plusButtonMenuElement);

    public abstract HomePageBase closePlusButtonMenu();

    public abstract ExtendedWebElement openPlusButtonMenu();

    public abstract boolean isPlusButtonBelowBlockContainer();

    public abstract boolean isBlockByTitlePresent(MaterialCardTopics topic) throws InterruptedException;

    public abstract List<String> getPlaylistTitlesToList();
}
