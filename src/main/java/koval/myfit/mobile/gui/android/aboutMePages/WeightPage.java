package koval.myfit.mobile.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.WeightPageBase;
import koval.myfit.mobile.service.enums.WeightMeasures;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WeightPageBase.class)
public class WeightPage extends WeightPageBase {


    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/unit_spinner']/child::*" +
            "[@class='android.widget.TextView']")
    private ExtendedWebElement weightMeasurementPicker;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//android.widget.EditText[@text='%s']")
    private ExtendedWebElement weightByText;

    @FindBy(xpath = "//*[contains(@resource-id, 'weight_value_picker_view')]/child::*//*" +
            "[@class='android.widget.NumberPicker'][1]")
    private ExtendedWebElement weightFirstValueContainer;

    @FindBy(xpath = "//*[contains(@resource-id, 'weight_value_picker_view')]/child::*//*" +
            "[@class='android.widget.NumberPicker'][2]")
    private ExtendedWebElement weightSecondValueContainer;

    @FindBy(xpath = "//*[contains(@resource-id, 'com.google.android.apps.fitness:id/weight_value_picker_view')]/" +
            "child::*//*[@class='android.widget.NumberPicker'][1]/child::*[@class='android.widget.EditText']")
    private ExtendedWebElement actualFirstWeightValue;

    @FindBy(xpath = "//*[contains(@resource-id, 'com.google.android.apps.fitness:id/weight_value_picker_view')]/" +
            "child::*//*[@class='android.widget.NumberPicker'][2]/child::*[@class='android.widget.EditText']")
    private ExtendedWebElement actualSecondWeightValue;


    @FindBy(id = "com.google.android.apps.fitness:id/alertTitle")
    private ExtendedWebElement title;

    public WeightPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {

        return isPageOpened(title, "Weight");
    }

    @Override
    public WeightPageBase setWeight(float weight, WeightMeasures measure) {

        setWeightMeasure(measure.getMeasure());

        int firstWeightValue = Integer.parseInt(String.valueOf(weight).split(SLASH_DOT_VALUE)[0]);
        int secondWeightValue = Integer.parseInt(String.valueOf(weight).split(SLASH_DOT_VALUE)[1]);

        int actualFirstWeight = Integer.parseInt(actualFirstWeightValue.getText().replaceAll(NUMBERS_ONLY, EMPTY_FIELD));
        int actualSecondWeight = Integer.parseInt(actualSecondWeightValue.getText().replaceAll(NUMBERS_ONLY, EMPTY_FIELD));


        setWeight(firstWeightValue, actualFirstWeight, measure.getFirstMeasure(), weightFirstValueContainer);
        setWeight(secondWeightValue, actualSecondWeight, measure.getSecondMeasure(), weightSecondValueContainer);

        itemByText.format("OK").click();

        return initPage(getDriver(), WeightPageBase.class);
    }

    @Override
    public WeightPageBase setWeight(int weightValue, float actualWeight, String measure, ExtendedWebElement weightContainer) {

        Direction direction = Direction.UP;

        if (weightValue < actualWeight) {
            direction = Direction.DOWN;
        }

        ExtendedWebElement expectedWeight = weightByText.format(weightValue + measure);
        swipe(expectedWeight, weightContainer, direction, FORTY_COUNT, HIGH_SPEED);

        return initPage(getDriver(), WeightPageBase.class);
    }


    @Override
    public WeightPageBase setWeightMeasure(String measure) {

        if (!weightMeasurementPicker.getText().equals(measure)) {
            weightMeasurementPicker.click();
            itemByText.format(measure).click();
        }

        return initPage(getDriver(), WeightPageBase.class);
    }

}
