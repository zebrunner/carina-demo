package koval.mobile.myfitnesspal.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.PlansPageBase;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlansPageBase.class)
public class PlansPage extends PlansPageBase {

    public PlansPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public PlansGoogleDocWebPageBase clickTakeSurvey() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSurveyTitleAtTheBottom() {
        throw new NotImplementedException();
    }

    @Override
    public PlansPageBase swipeToSurveyTitle(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSectionSurveyPresent(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public Point getLocationElement() {
        throw new NotImplementedException();
    }


    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }


}
