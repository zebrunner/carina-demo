package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


public abstract class PlansPageBase extends MyAbstractPageBase {

    public PlansPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(int timeout);


    public abstract boolean isPlansHubScreenOpen();

    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);
}
