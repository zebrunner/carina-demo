package koval.mobile.myfit.gui.ios.loginPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.loginPages.AboutMePageBase;
import koval.mobile.myfit.gui.common.loginPages.TrackActivitiesPageBase;
import koval.mobile.myfit.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutMePageBase.class)
public class AboutMePage extends AboutMePageBase {

    public AboutMePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TrackActivitiesPageBase clickNextBtn() {
        throw new NotImplementedException();
    }

    @Override
    public AboutMePageBase clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics) {
        throw new NotImplementedException();
    }

}
