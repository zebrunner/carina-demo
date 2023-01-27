package koval.mobile.gui.pages.common.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.service.enums.Topic;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class WebViewPageBase extends AbstractPage {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getTopicsToListFirst();

    public abstract List<String> getTopicsToList();

    public abstract String getFirstTopic();

    public abstract List<String> getRightMenuElementsToList();

    public abstract String getParsedEmail();

    public abstract String getEmailAgent();

    public abstract String getEmailName();

    public abstract AbstractPage openPageByIndex(int pageIndex);

    public abstract AbstractPage openMenu();


    public abstract boolean isWebViewElementPresent(long timeOut);

    public abstract boolean isEmailTextElementPresent(long timeOut);

    public abstract boolean isTopicPresent(long timeOut);

    public abstract boolean isTopicPresent(Topic topic);
}
