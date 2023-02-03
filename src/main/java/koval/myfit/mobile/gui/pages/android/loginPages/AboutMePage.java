package koval.myfit.mobile.gui.pages.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.carinademo.mobile.gui.pages.service.interfaces.IConstantUtils;
import koval.myfit.mobile.gui.pages.common.loginPages.AboutMePageBase;
import koval.myfit.mobile.gui.pages.common.loginPages.TrackActivitiesPageBase;
import koval.myfit.mobile.gui.pages.service.enums.LoginPagesTitles;
import koval.myfit.mobile.gui.pages.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutMePageBase.class)
public class AboutMePage extends AboutMePageBase {


    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okayButton;

    @FindBy(id = "com.google.android.apps.fitness:id/%s_field")
    private ExtendedWebElement itemByID;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/heart_logo_animation']//following-sibling::*[@class = 'android.widget.TextView'][1]")
    private ExtendedWebElement title;

    @FindBy(id = "com.google.android.apps.fitness:id/next_button")
    private ExtendedWebElement nextButton;

    public AboutMePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_FIVE)
                && title.getText().equals(LoginPagesTitles.ABOUT_ME.getTitle())
                && nextButton.isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public TrackActivitiesPageBase clickNextBtn() {
        nextButton.click();
        return initPage(getDriver(), TrackActivitiesPageBase.class);
    }


    @Override
    public AboutMePageBase clickOnBtn(PersonCharacteristics personCharacteristics) {
        itemByID.format(personCharacteristics.getCharacteristic()).click();
        okayButton.click();
        return initPage(getDriver(), AboutMePageBase.class);
    }

}
