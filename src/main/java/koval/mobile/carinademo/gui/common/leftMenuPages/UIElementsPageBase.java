package koval.mobile.carinademo.gui.common.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class UIElementsPageBase extends AbstractPage {

    public UIElementsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProfileImagePresent(long timeOut);

}
