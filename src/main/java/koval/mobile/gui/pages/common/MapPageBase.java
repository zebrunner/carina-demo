package koval.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.service.enums.Tab;
import org.openqa.selenium.WebDriver;

public abstract class MapPageBase extends AbstractPage {

    public MapPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isMapImagePresent();
}
