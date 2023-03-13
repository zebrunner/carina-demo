package koval.mobile.myfit.gui.common.loginPages;

import koval.mobile.myfit.gui.common.downMenuPages.HomePageBase;
import koval.mobile.myfit.gui.MyAbstractPage;
import koval.mobile.myfit.service.enums.TrackYourActivitiesAnswer;
import org.openqa.selenium.WebDriver;


public abstract class TrackActivitiesPageBase extends MyAbstractPage {

    public TrackActivitiesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase clickOnAnswerBtn(TrackYourActivitiesAnswer trackYourActivitiesAnswer);
}
