package koval.myfit.mobile.gui.ios.aboutMePages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.GenderPageBase;
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
