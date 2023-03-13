package koval.mobile.myfit.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.aboutMePages.BirthdayPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BirthdayPageBase.class)
public class BirthdayPage extends BirthdayPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBackButton;

    @FindBy(xpath = "//*[@class='android.widget.Spinner']")
    private ExtendedWebElement monthSpinner;

    @FindBy(xpath = "//*[@class='android.widget.Spinner']//following-sibling::*[@class='android.view.View']")
    private ExtendedWebElement monthSpinnerContainer;

    @FindBy(xpath = "//*[@class='android.widget.Spinner']//following-sibling::*//*[@class='android.widget.ListView']" +
            "/child::*[@class='android.view.View']")
    private List<ExtendedWebElement> monthList;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//*[@text='%s']//following-sibling::*[@class='android.widget.EditText']")
    private ExtendedWebElement dateFieldByText;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public BirthdayPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return itemByText.format("Birthday").isElementPresent(TIMEOUT_TEN);
    }


    @Override
    public BirthdayPageBase setDate(Calendar expectedBirthday) {

        String birthdaySt = new SimpleDateFormat(MONTH_DATE_FORMAT).format(expectedBirthday.getTime());

        if (!monthSpinner.getText().contains(birthdaySt)) {

            monthSpinner.click();

            int currentMonthIndex = 0;

            for (int i = 0; i < monthList.size(); i++) {
                if (monthList.get(i).getAttribute("selected").equals(TRUE_ANSWER))
                    currentMonthIndex = i;
            }

            ExtendedWebElement expectedMonth = itemByText.format(birthdaySt);
            if (expectedBirthday.get(Calendar.MONTH) < currentMonthIndex) {

                if (!expectedMonth.isChecked()) {
                    swipeInContainer(monthSpinnerContainer, Direction.DOWN, THREE_COUNT, HIGH_SPEED);

                }

            } else {
                swipe(expectedMonth, monthSpinnerContainer, Direction.UP, THREE_COUNT, HIGH_SPEED);
            }

            monthList.get(expectedBirthday.get(Calendar.MONTH)).click();
        }


        if (!dateFieldByText.format(DAY_VALUE).getText().equals(String.valueOf(expectedBirthday.get(Calendar.DAY_OF_MONTH)))) {
            dateFieldByText.format(DAY_VALUE).type(String.valueOf(expectedBirthday.get(Calendar.DAY_OF_MONTH)));
        }


        if (!dateFieldByText.format(YEAR_VALUE).getText().equals(String.valueOf(expectedBirthday.get(Calendar.YEAR)))) {
            dateFieldByText.format(YEAR_VALUE).type(String.valueOf(expectedBirthday.get(Calendar.YEAR)));
        }


        return initPage(getDriver(), BirthdayPageBase.class);
    }

    @Override
    public BirthdayPageBase saveChanges() {

        itemByText.format(SAVE_VALUE).click();

        itemByText.format(CONFIRM_VALUE).click();

        return initPage(getDriver(), BirthdayPageBase.class);
    }


    @Override
    public BirthdayPageBase returnBack() {

        navigateBackButton.click();

        return initPage(getDriver(), BirthdayPageBase.class);
    }

}
