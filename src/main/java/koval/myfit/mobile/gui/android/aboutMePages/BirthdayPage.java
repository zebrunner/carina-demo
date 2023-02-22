package koval.myfit.mobile.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.BirthdayPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BirthdayPageBase.class)
public class BirthdayPage extends BirthdayPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBackButton;

    @FindBy(xpath = "//android.view.View[@text='%s']//following-sibling::*[@class='android.widget.EditText']")
    private ExtendedWebElement dateFieldByText;

    @FindBy(xpath = "//*[@class='android.widget.Spinner']")
    private ExtendedWebElement monthSpinner;


    @FindBy(xpath = "//*[@class='android.widget.Spinner']//following-sibling::*//*[@text='Menu for selecting month of birth']")
    private ExtendedWebElement monthSpinnerContainer;


    @FindBy(xpath = "//*[@class='android.widget.Spinner']//following-sibling::*//*[@class='android.widget.ListView']/child::*[@class='android.view.View']")
    private List<ExtendedWebElement> monthList;


    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;


    public BirthdayPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public BirthdayPageBase setDate(Calendar calendar) {


        monthSpinner.click();


        String birthdaySt = new SimpleDateFormat(MONTH_DATE_FORMAT).format(calendar.getTime());

        ExtendedWebElement expectedMonth = itemByText.format(birthdaySt);
        swipe(expectedMonth, monthSpinnerContainer, Direction.UP, FORTY_COUNT, HIGH_SPEED);

        monthList.get(calendar.get(Calendar.MONTH)).click();


        dateFieldByText.format("Day").type(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));

        dateFieldByText.format("Year").type(String.valueOf(calendar.get(Calendar.YEAR)));


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
