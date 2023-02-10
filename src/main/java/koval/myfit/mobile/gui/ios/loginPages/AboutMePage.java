package koval.myfit.mobile.gui.ios.loginPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.loginPages.AboutMePageBase;
import koval.myfit.mobile.gui.common.loginPages.TrackActivitiesPageBase;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
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
