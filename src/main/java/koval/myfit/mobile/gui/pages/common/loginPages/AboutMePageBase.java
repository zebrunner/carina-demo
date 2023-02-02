package koval.myfit.mobile.gui.pages.common.loginPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.pages.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;

import java.util.List;


public abstract class AboutMePageBase extends AbstractPage {
    public AboutMePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TrackActivitiesPageBase clickNextBtn();

    public abstract AboutMePageBase clickOnBtn(PersonCharacteristics personCharacteristics);
}
