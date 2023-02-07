package koval.myfit.mobile.gui.pages.common.loginPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.pages.service.MyAbstractPage;
import koval.myfit.mobile.gui.pages.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;



public abstract class AboutMePageBase extends MyAbstractPage {
    public AboutMePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TrackActivitiesPageBase clickNextBtn();

    public abstract AboutMePageBase clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics);
}
