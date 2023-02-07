package koval.myfit.mobile.gui.pages.ios.loginPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.carinademo.mobile.gui.pages.service.interfaces.IConstantUtils;
import koval.myfit.mobile.gui.pages.common.loginPages.AboutMePageBase;
import koval.myfit.mobile.gui.pages.common.loginPages.TrackActivitiesPageBase;
import koval.myfit.mobile.gui.pages.service.enums.PersonCharacteristics;
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
