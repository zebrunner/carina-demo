package koval.mobile.myfit.gui.ios.aboutMePages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.aboutMePages.GenderPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GenderPageBase.class)
public class GenderPage extends GenderPageBase {

    public GenderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GenderPageBase checkGenderByName(String gender) {
        throw new NotImplementedException();
    }

}
