package koval.myfit.mobile.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.BirthdayPageBase;
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

    @FindBy(xpath = "//*[@class='android.widget.Spinner']//following-sibling::*//*" +
            "[@text='Menu for selecting month of birth']")
    private ExtendedWebElement monthSpinnerContainer;

    @FindBy(xpath = "//*[@class='android.widget.Spinner']//following-sibling::*//*[@class='android.widget.ListView']" +
            "/child::*[@class='android.view.View']")
    private List<ExtendedWebElement> monthList;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//android.view.View[@text='%s']//following-sibling::*[@class='android.widget.EditText']")
    private ExtendedWebElement dateFieldByText;

    @FindBy(xpath = "//*[@resource-id='com.google.android.gms:id/octarine_webview_container']/child::*//*" +
            "[@resource-id='yDmH0d']/child::*//*[@class='android.view.View'][1]/child::*//android.view.View[@text='%s']")
    private ExtendedWebElement title;


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public BirthdayPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return title.format("Birthday").isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public BirthdayPageBase setDate(Calendar calendar) {

        String birthdaySt = new SimpleDateFormat(MONTH_DATE_FORMAT).format(calendar.getTime());

        if (!monthSpinner.getText().contains(birthdaySt)) {

            monthSpinner.click();

            int currentMonthIndex = 0;

            for (int i = 0; i < monthList.size(); i++) {
                if (monthList.get(i).getAttribute("selected").equals("true"))
                    currentMonthIndex = i;
            }

            Direction direction = Direction.UP;

            if (calendar.get(Calendar.MONTH) > currentMonthIndex ) {
                direction = Direction.DOWN;
            }

            ExtendedWebElement expectedMonth = itemByText.format(birthdaySt);
            swipe(expectedMonth, monthSpinnerContainer, direction, FORTY_COUNT, HIGH_SPEED);

            monthList.get(calendar.get(Calendar.MONTH)).click();
        }


        if (!dateFieldByText.format(DAY_VALUE).getText().equals(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)))) {
            dateFieldByText.format(DAY_VALUE).type(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        }


        if (!dateFieldByText.format(YEAR_VALUE).getText().equals(String.valueOf(calendar.get(Calendar.YEAR)))) {
            dateFieldByText.format(YEAR_VALUE).type(String.valueOf(calendar.get(Calendar.YEAR)));
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
