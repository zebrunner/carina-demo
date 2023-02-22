package koval.myfit.mobile.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.BirthdayPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BirthdayPageBase.class)
public class BirthdayPage extends BirthdayPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBackButton;

    @FindBy(xpath = "//android.view.View[@text='%s']//following-sibling::*[@class='android.widget.EditText']")
    private ExtendedWebElement dateFieldByText;

    @FindBy(xpath = "//*[@class='android.widget.Spinner']")
    private ExtendedWebElement monthSpinner;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;


    public BirthdayPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public BirthdayPageBase setDate() {


        dateFieldByText.format("Day").type("12");

        dateFieldByText.format("Year").type("1999");


        return initPage(getDriver(), BirthdayPageBase.class);
    }

    @Override
    public BirthdayPageBase saveChanges() {

        itemByText.format("Save").click();

        itemByText.format("Confirm").click();

        return initPage(getDriver(), BirthdayPageBase.class);
    }


    @Override
    public BirthdayPageBase returnBack() {

        navigateBackButton.click();

        return initPage(getDriver(), BirthdayPageBase.class);
    }


}
