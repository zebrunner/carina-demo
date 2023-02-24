package koval.myfit.mobile.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.android.modal.AboutMeModal;
import koval.myfit.mobile.gui.common.loginPages.AboutMePageBase;
import koval.myfit.mobile.gui.common.loginPages.TrackActivitiesPageBase;
import koval.myfit.mobile.service.enums.LoginPagesTitles;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutMePageBase.class)
public class AboutMePage extends AboutMePageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/about_you_placeholder")
    private AboutMeModal aboutMeModal;


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
    public AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics) {
        return aboutMeModal.clickOnCharacteristicsBtn(personCharacteristics);
    }

}
