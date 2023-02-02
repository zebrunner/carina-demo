package koval.myfit.mobile.gui.pages.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.carinademo.mobile.gui.pages.service.interfaces.IConstantUtils;
import koval.myfit.mobile.gui.pages.common.loginPages.TrackActivitiesPageBase;
import koval.myfit.mobile.gui.pages.common.menuPages.HomePageBase;
import koval.myfit.mobile.gui.pages.service.enums.LoginPagesTitles;
import koval.myfit.mobile.gui.pages.service.enums.TrackYourActivitiesAnswer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TrackActivitiesPageBase.class)
public class TrackActivitiesPage extends TrackActivitiesPageBase implements IMobileUtils, IConstantUtils {

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
    public HomePageBase clickBtn(TrackYourActivitiesAnswer trackYourActivitiesAnswer) {
        itemByText.format(trackYourActivitiesAnswer.getAnswer()).click();
        return initPage(getDriver(), HomePageBase.class);
    }

}
