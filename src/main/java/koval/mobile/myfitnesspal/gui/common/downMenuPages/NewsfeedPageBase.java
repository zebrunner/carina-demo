package koval.mobile.myfitnesspal.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


public abstract class NewsfeedPageBase extends MyAbstractPageBase {

    public NewsfeedPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);
}
