package koval.myfit.mobile.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.loginPages.AboutMePageBase;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;


public abstract class ProfilePageBase extends MyAbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics);
}
