package koval.myfit.mobile.gui.android.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.myfit.mobile.gui.common.modal.ManageAccountModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ManageAccountModalBase.class)
public class ManageAccountModal extends ManageAccountModalBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(id = "com.google.android.apps.fitness:id/og_apd_internal_image_view")
    private ExtendedWebElement accountImage;

    public ManageAccountModal(WebDriver driver) {
        super(driver);
    }

    public ManageAccountModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public int getAccountImageColor() throws IOException {
        return getColorByNumber(accountImage);
    }



}
