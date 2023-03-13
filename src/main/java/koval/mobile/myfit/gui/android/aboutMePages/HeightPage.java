package koval.mobile.myfit.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.myfit.gui.common.aboutMePages.HeightPageBase;
import koval.mobile.myfit.service.interfaces.IConstantUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeightPageBase.class)
public class HeightPage extends HeightPageBase {


    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/unit_picker']/child::*" +
            "[@class='android.widget.TextView']")
    private ExtendedWebElement heightMeasurementPicker;

    @FindBy(className = "android.widget.NumberPicker")
    private ExtendedWebElement heightCentimeterContainer;

    @FindBy(xpath = "//*[contains(@resource-id, 'imperial_picker')]/child::*[@class='android.widget.NumberPicker'][1]")
    private ExtendedWebElement heightFeetContainer;

    @FindBy(xpath = "//*[contains(@resource-id, 'imperial_picker')]/child::*[@class='android.widget.NumberPicker'][2]")
    private ExtendedWebElement heightInchContainer;

    @FindBy(id = "android:id/numberpicker_input")
    private ExtendedWebElement actualCentimeterValue;

    @FindBy(xpath = "//*[contains(@resource-id, 'imperial_picker')]/child::*[@class='android.widget.NumberPicker'][1]/" +
            "child::*[@class='android.widget.EditText']")
    private ExtendedWebElement actualFeetValue;

    @FindBy(xpath = "//*[contains(@resource-id, 'imperial_picker')]/child::*[@class='android.widget.NumberPicker'][2]/" +
            "child::*[@class='android.widget.EditText']")
    private ExtendedWebElement actualInchValue;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//android.widget.EditText[@text='%s']")
    private ExtendedWebElement heightByText;

    @FindBy(id = "com.google.android.apps.fitness:id/alertTitle")
    private ExtendedWebElement title;


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public HeightPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return isPageOpened(title, "Height");
    }

    @Override
    public HeightPageBase setHeight(int centimeters) {

        setHeightMeasure("Centimeters");

        int actualCentimeters = Integer.parseInt(actualCentimeterValue.getText().replaceAll(IConstantUtils.NUMBERS_ONLY, IConstantUtils.EMPTY_FIELD));

        setHeight(centimeters, actualCentimeters, IConstantUtils.CENTIMETERS_MEASURE, heightCentimeterContainer);

        itemByText.format(IConstantUtils.OKAY_ANSWER).click();

        return initPage(getDriver(), HeightPageBase.class);
    }

    @Override
    public HeightPageBase setHeight(float feetInch) {

        setHeightMeasure("Feet & inches");

        int feetValue = Integer.parseInt(String.valueOf(feetInch).split(IConstantUtils.BACKSLASH_DOT_VALUE)[0]);
        int inchValue = Integer.parseInt(String.valueOf(feetInch).split(IConstantUtils.BACKSLASH_DOT_VALUE)[1]);

        int actualFeet = Integer.parseInt(actualFeetValue.getText().replaceAll(IConstantUtils.NUMBERS_ONLY, IConstantUtils.EMPTY_FIELD));
        int actualInch = Integer.parseInt(actualInchValue.getText().replaceAll(IConstantUtils.NUMBERS_ONLY, IConstantUtils.EMPTY_FIELD));


        setHeight(feetValue, actualFeet, IConstantUtils.FOOT_MEASURE, heightFeetContainer);
        setHeight(inchValue, actualInch, IConstantUtils.INCH_MEASURE, heightInchContainer);

        itemByText.format(IConstantUtils.OKAY_ANSWER).click();

        return initPage(getDriver(), HeightPageBase.class);
    }


    @Override
    public HeightPageBase setHeight(int heightValue, float actualHeight, String measure, ExtendedWebElement heightContainer) {

        IMobileUtils.Direction direction = IMobileUtils.Direction.UP;

        if (heightValue < actualHeight) {
            direction = IMobileUtils.Direction.DOWN;
        }

        ExtendedWebElement expectedHeight = heightByText.format(heightValue + measure);
        swipe(expectedHeight, heightContainer, direction, IConstantUtils.FORTY_COUNT, IConstantUtils.HIGH_SPEED);

        return initPage(getDriver(), HeightPageBase.class);
    }

    @Override
    public HeightPageBase setHeightMeasure(String measure) {

        if (!heightMeasurementPicker.getText().equals(measure)) {
            heightMeasurementPicker.click();
            itemByText.format(measure).click();
        }

        return initPage(getDriver(), HeightPageBase.class);
    }


}
