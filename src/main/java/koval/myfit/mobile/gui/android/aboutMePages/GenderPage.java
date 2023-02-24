package koval.myfit.mobile.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.GenderPageBase;
import koval.myfit.mobile.service.enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GenderPageBase.class)
public class GenderPage extends GenderPageBase {


    @FindBy(xpath = "//android.widget.RadioButton[@text='%s']")
    private ExtendedWebElement radioButtonByText;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBackButton;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    public GenderPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {

        return itemByText.format("Gender").isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public GenderPageBase checkGenderByName(String gender) {

        radioButtonByText.format(gender).check();
        navigateBackButton.click();

        return initPage(getDriver(), GenderPageBase.class);
    }

}
