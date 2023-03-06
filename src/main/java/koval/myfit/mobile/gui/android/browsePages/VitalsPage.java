package koval.myfit.mobile.gui.android.browsePages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.browsePages.VitalsPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = VitalsPageBase.class)
public class VitalsPage extends VitalsPageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/card_chart_title")
    private ExtendedWebElement bloodPressureText;

    public VitalsPage(WebDriver driver) {
        super(driver);
    }

    String bloodPressureNumber = bloodPressureText.getText();

    @Override
    public int getTopNumberBloodPressure() {

        return Integer.parseInt(StringUtils.split(bloodPressureNumber, SLASH_VALUE)[0]);
    }

    @Override
    public int getBottomNumberBloodPressure() {

        return Integer.parseInt(StringUtils.split(bloodPressureNumber, SLASH_VALUE)[1].
                replaceAll(MMHG_MEASURE, EMPTY_FIELD));
    }

}
