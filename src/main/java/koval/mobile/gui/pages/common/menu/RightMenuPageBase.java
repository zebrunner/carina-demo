package koval.mobile.gui.pages.common.menu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.service.enums.RightMenu;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class RightMenuPageBase extends AbstractPage {

    public RightMenuPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isRightMenuContainsAllElements();

    public abstract RightMenuPageBase openMenu();


    public abstract RightMenuPageBase openPage(RightMenu menu);

    public abstract boolean isElementPresent(RightMenu menu);
}
