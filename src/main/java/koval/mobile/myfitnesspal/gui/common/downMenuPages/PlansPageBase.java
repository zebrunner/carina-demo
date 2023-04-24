package koval.mobile.myfitnesspal.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


public abstract class PlansPageBase extends MyAbstractPageBase {

    public PlansPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);
}
