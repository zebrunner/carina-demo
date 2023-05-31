package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;


public abstract class PlansPageBase extends MyAbstractPageBase {

    public PlansPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(int timeout);

    public abstract PlansGoogleDocWebPageBase clickTakeSurvey();

    public abstract boolean isSurveyTitleAtTheBottom();

    public abstract PlansHubPageBase clickOnPlusSign();

    public abstract PlansPageBase closeWelcomeMessageIfPresent(int timeout);

    public abstract PlansPageBase swipeToSurveyTitle(int timeout);

    public abstract boolean isSectionSurveyPresent(int timeout);

    public abstract Point getLocationElement();

    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);
}
