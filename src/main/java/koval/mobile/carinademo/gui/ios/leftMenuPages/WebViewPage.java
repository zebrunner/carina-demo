package koval.mobile.carinademo.gui.ios.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.carinademo.gui.common.leftMenuPages.WebViewPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {
    public WebViewPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public List<String> getTopicsToList() {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getRightMenuElementsToList() {
        throw new NotImplementedException();
    }

    @Override
    public String getEmail() {
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }

}
