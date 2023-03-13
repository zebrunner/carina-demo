package koval.mobile.myfit.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.downMenuPages.HomePageBase;
import koval.mobile.myfit.gui.common.loginPages.TrackActivitiesPageBase;
import koval.mobile.myfit.service.enums.LoginPagesTitles;
import koval.mobile.myfit.service.enums.TrackYourActivitiesAnswer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TrackActivitiesPageBase.class)
public class TrackActivitiesPage extends TrackActivitiesPageBase {

    @FindBy(xpath = "//*[@class = 'android.widget.TextView'][1]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.Button[@text='%s']")
    private ExtendedWebElement itemByText;


    public TrackActivitiesPage(WebDriver driver) {
        super(driver);
    }


    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_FIVE) && title.getText().equals(LoginPagesTitles.TRACK_YOUR_ACTIVITIES.getTitle());
    }

    @Override
    public HomePageBase clickOnAnswerBtn(TrackYourActivitiesAnswer trackYourActivitiesAnswer) {
        itemByText.format(trackYourActivitiesAnswer.getAnswer()).click();
        return initPage(getDriver(), HomePageBase.class);
    }

}
