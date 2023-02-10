package koval.myfit.mobile.gui.common.loginPages;

import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.service.enums.TrackYourActivitiesAnswer;
import org.openqa.selenium.WebDriver;


public abstract class TrackActivitiesPageBase extends MyAbstractPage {

    public TrackActivitiesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase clickOnAnswerBtn(TrackYourActivitiesAnswer trackYourActivitiesAnswer);
}
