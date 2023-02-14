package koval.myfit.mobile.gui.android;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ActivityPageBase.class)
public class ActivityPage extends ActivityPageBase {



    @FindBy(id = "com.google.android.apps.fitness:id/subtitle")
    private ExtendedWebElement dateTimeDurationLabel;
    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.fitness:id/title")
    private ExtendedWebElement title;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private ExtendedWebElement moreActionButton;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okayButton;

    public ActivityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String activityName) {

        return isPageOpened(title, activityName);
    }

    @Override
    public JournalPageBase deleteActivity() {

       moreActionButton.click();
       itemByText.format("Delete").click();
       deleteButton.click();

        return initPage(getDriver(), JournalPageBase.class);
    }
}
