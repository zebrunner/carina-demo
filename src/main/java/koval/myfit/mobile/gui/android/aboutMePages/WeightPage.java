package koval.myfit.mobile.gui.android.aboutMePages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.aboutMePages.WeightPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WeightPageBase.class)
public class WeightPage extends WeightPageBase {


    public WeightPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public WeightPageBase setWeight(){

        Direction direction = Direction.UP;

//        int actualBloodPressureNumber = Integer.parseInt(bloodPressureElement.getText());
//        LOGGER.info(String.valueOf(actualBloodPressureNumber));
//
//        if (bloodPressureNumber < actualBloodPressureNumber) {
//            direction = Direction.DOWN;
//        }
//
//        ExtendedWebElement bloodPressurePicker = bloodPressureByTextPicker.format(bloodPressureNumber);
//        swipe(bloodPressurePicker, bloodPressureContainer, direction, FORTY_COUNT, HIGH_SPEED_200);
//


        return initPage(getDriver(), WeightPageBase.class);
    }



}
