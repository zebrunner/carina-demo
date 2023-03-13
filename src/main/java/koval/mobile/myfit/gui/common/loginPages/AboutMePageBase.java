package koval.mobile.myfit.gui.common.loginPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.MyAbstractPage;
import koval.mobile.myfit.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;



public abstract class AboutMePageBase extends MyAbstractPage {

    public AboutMePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TrackActivitiesPageBase clickNextBtn();

    public abstract AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics);
}
