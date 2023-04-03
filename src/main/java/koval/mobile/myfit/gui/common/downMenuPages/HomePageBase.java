package koval.mobile.myfit.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfit.gui.common.modal.PlusButtonModalBase;
import koval.mobile.myfit.gui.MyAbstractPage;
import koval.mobile.myfit.service.enums.DownMenuElement;
import koval.mobile.myfit.service.enums.MaterialCardTopics;
import koval.mobile.myfit.service.enums.PlusButtonMenuElement;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;


public abstract class HomePageBase extends MyAbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract boolean isPageOpened(Long timeout);

    public abstract WelcomePageBase signOut();


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);

    public abstract boolean isPlusBtnStatic();

    public abstract boolean isPlusBtnOverElements();

    public abstract AbstractPage openPageFromPlusButtonMenuByName(PlusButtonMenuElement plusButtonMenuElement);

    public abstract HomePageBase closePlusButtonMenu();

    public abstract PlusButtonModalBase openPlusButtonMenu();

    public abstract boolean isPlusButtonBelowBlockContainer();

    public abstract int getAccountImageColor() throws IOException;

    public abstract String getChartTitleColor() throws IOException;

    public abstract String getHeartCardImage() throws IOException;

    public abstract int getMetricValueListSize() throws IOException;

    public abstract String getMetricValueColor(int i) throws IOException;

    public abstract String getHeartPtsLabelColor() throws IOException;

    public abstract String getHeartPointsTitleColor() throws IOException;

    public abstract boolean isBlockByTitlePresent(MaterialCardTopics topic) throws InterruptedException;

    public abstract List<String> getPlaylistTitlesToList();


}
