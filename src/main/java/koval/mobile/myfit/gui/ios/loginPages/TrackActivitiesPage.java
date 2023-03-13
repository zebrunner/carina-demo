package koval.mobile.myfit.gui.ios.loginPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.downMenuPages.HomePageBase;
import koval.mobile.myfit.gui.common.loginPages.TrackActivitiesPageBase;
import koval.mobile.myfit.service.enums.TrackYourActivitiesAnswer;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = TrackActivitiesPageBase.class)
public class TrackActivitiesPage extends TrackActivitiesPageBase {

    public TrackActivitiesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase clickOnAnswerBtn(TrackYourActivitiesAnswer trackYourActivitiesAnswer) {
        throw new NotImplementedException();
    }


}
