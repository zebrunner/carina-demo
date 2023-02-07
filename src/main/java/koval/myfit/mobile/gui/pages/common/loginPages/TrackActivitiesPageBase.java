package koval.myfit.mobile.gui.pages.common.loginPages;

import koval.myfit.mobile.gui.pages.common.menuPages.HomePageBase;
import koval.myfit.mobile.gui.pages.service.MyAbstractPage;
import koval.myfit.mobile.gui.pages.service.enums.TrackYourActivitiesAnswer;
import org.openqa.selenium.WebDriver;


public abstract class TrackActivitiesPageBase extends MyAbstractPage {
    public TrackActivitiesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase clickOnAnswerBtn(TrackYourActivitiesAnswer trackYourActivitiesAnswer);
}
