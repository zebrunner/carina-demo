package koval.myfit.mobile.gui.pages.common.menuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.pages.service.MyAbstractPage;
import koval.myfit.mobile.gui.pages.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;

import java.util.List;


public abstract class HomePageBase extends MyAbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract WelcomePageBase signOut();

    public abstract AbstractPage open(DownMenuElement downMenuElement);


    public abstract List<String> getPlusButtonMenuElementsToList();


    public abstract boolean isPlusBtnStatic();


    public abstract int getContainerHeight();

    public abstract List<String> getMaterialCardTopicsToList();

    public abstract List<String> getPlaylistTitlesToList();
}
