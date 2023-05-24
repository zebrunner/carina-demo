package koval.mobile.carinademo.gui.android.leftMenuPages;

import koval.mobile.carinademo.gui.common.leftMenuPages.ChartsPageBase;
import koval.mobile.carinademo.service.enums.LeftMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {
    
    @FindBy(xpath = "//*[@resource-id='com.solvd.carinademoapplication:id/toolbar']/child::*[@class='android.widget.TextView']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.View[@text='venn chart ']")
    private ExtendedWebElement vennDiagram;

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(LeftMenu.CHARTS.getPageName());
    }

    @Override
    public boolean isVennDiagramPresent(long timeOut) {
        return vennDiagram.isElementPresent(timeOut);
    }
}
