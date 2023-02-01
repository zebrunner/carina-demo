package koval.mobile.gui.pages.common.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class WebViewPageBase extends AbstractPage {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getTopicsToList();

    public abstract List<String> getRightMenuElementsToList();

    public abstract String getEmail();


    public abstract AbstractPage openPageByIndex(int pageIndex);

    public abstract AbstractPage openMenu();

    public abstract boolean isWebViewElementPresent(long timeOut);

}
