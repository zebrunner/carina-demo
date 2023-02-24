package koval.myfit.mobile.gui.common.loginPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;



public abstract class AboutMePageBase extends MyAbstractPage {

    public AboutMePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TrackActivitiesPageBase clickNextBtn();

    public abstract AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics);
}
