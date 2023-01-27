package koval.mobile.gui.pages.ios.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.mobile.gui.pages.service.enums.Topic;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {
    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getTopicsToListFirst() {
        return null;
    }

    @Override
    public List<String> getTopicsToList() {
        return null;
    }


    @Override
    public String getFirstTopic() {
        return null;
    }

    @Override
    public List<String> getRightMenuElementsToList() {
        throw new NotImplementedException();
    }

    @Override
    public String[] getParsedEmail() {
        return null;
    }

    @Override
    public String getEmailAgent() {
        return null;
    }

    @Override
    public String getEmailName() {
        return null;
    }


    @Override
    public AbstractPage openPageByIndex(int pageIndex) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openMenu() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isWebViewElementPresent(long timeOut) {
        return false;
    }

    @Override
    public boolean isEmailTextElementPresent(long timeOut) {
        return false;
    }

    @Override
    public boolean isTopicPresent(long timeOut) {
        return false;
    }

    @Override
    public boolean isTopicPresent(Topic topic) {
        return false;
    }


}
