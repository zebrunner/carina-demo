package koval.carinademo.mobile.gui.ios.leftMenuPages;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.carinademo.mobile.gui.common.leftMenuPages.MapPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isMapImagePresent(long timeOut) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }


}
