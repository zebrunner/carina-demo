package koval.myfit.mobile.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.HeightPageBase;
import koval.myfit.mobile.gui.common.aboutMePages.WeightPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeightPageBase.class)
public class HeightPage extends HeightPageBase {




    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/unit_picker']/child::*[@class='android.widget.TextView']")
    private ExtendedWebElement heightMeasurement;


    @FindBy(id = "com.google.android.apps.fitness:id/unit_picker")
    private ExtendedWebElement heightMeasurementPicker;

    @FindBy(xpath = "android:id/numberpicker_input")
    private ExtendedWebElement actualCentimeterValue;

    @FindBy(className = "android.widget.NumberPicker")
    private ExtendedWebElement heightContainer;



    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//android.widget.EditText[@text='%s cm']")
    private ExtendedWebElement heightByText;


    public HeightPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public WeightPageBase setHeight(int centimeters){

        if(!heightMeasurement.getText().equals("Centimeters"))
        {
            heightMeasurementPicker.click();
            itemByText.format("Centimeters").click();

        }

        Direction direction = Direction.UP;

        int actualCentimeters = Integer.parseInt(actualCentimeterValue.getText());


        if (centimeters < actualCentimeters) {
            direction = Direction.DOWN;
        }

        ExtendedWebElement expectedCentimetersHeight = heightByText.format(centimeters);
        swipe(expectedCentimetersHeight, heightContainer, direction, FORTY_COUNT, HIGH_SPEED);



        return initPage(getDriver(), WeightPageBase.class);
    }
    @Override
    public WeightPageBase setHeight(float centimeters){

        if(!heightMeasurement.getText().equals("Feet & inches"))
        {
            heightMeasurementPicker.click();
            itemByText.format("Feet & inches").click();

        }




        Direction direction = Direction.UP;

        int actualFeet = Integer.parseInt(actualCentimeterValue.getText());


        if (centimeters < actualFeet) {
            direction = Direction.DOWN;
        }

        ExtendedWebElement expectedCentimetersHeight = heightByText.format(centimeters);
        swipe(expectedCentimetersHeight, heightContainer, direction, FORTY_COUNT, HIGH_SPEED);



        return initPage(getDriver(), WeightPageBase.class);
    }







}
