package koval.myfit.mobile.gui.pages.service;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.myfit.mobile.gui.pages.service.interfaces.IConstantUtils;
import org.openqa.selenium.WebDriver;

public abstract class MyAbstractPage extends AbstractPage implements IConstantUtils, IMobileUtils {

    public MyAbstractPage(WebDriver driver) {
        super(driver);
    }

}
