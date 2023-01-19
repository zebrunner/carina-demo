package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.*;
import koval.mobile.gui.pages.service.enums.Tab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = CarinaDescriptionPageBase.class)
public class CarinaDescriptionPage extends CarinaDescriptionPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "content_frame")
    private ExtendedWebElement webViewContent;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement burgerMenuButton;

    /**
     * Carina Description Page: Icons from burger menu
     * Web View, Charts, Maps, UI Elements in one webelement
     */
    @FindBy(xpath = "//android.widget.CheckedTextView[@text = '%s']")
    private ExtendedWebElement elementTab;

    public CarinaDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementPresent() {
        return webViewContent.isElementPresent();
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public CarinaDescriptionPageBase clickOnBurgerMenu() {
        burgerMenuButton.click();
        return initPage(getDriver(), CarinaDescriptionPageBase.class);
    }

    @Override
    public boolean isSelectedElementPresent(Tab tab) {
        return elementTab.format(tab.getLabel()).isElementPresent();
    }


    @Override
    public AbstractPage clickOnTab(Tab tab) {

        elementTab.format(tab.getLabel()).click();

        switch (tab.getLabel()) {
            case "Web View": {
                //return initPage(getDriver(), WebViewPageBase.class);
                return initPage(getDriver(), CarinaDescriptionPageBase.class);
            }
            case "Charts": {
                return initPage(getDriver(), ChartsPageBase.class);
            }
            case "Map": {
                return initPage(getDriver(), MapPageBase.class);
            }
            case "UI elements": {
                return initPage(getDriver(), UIElementsPageBase.class);
            }
        }

        return initPage(getDriver(), CarinaDescriptionPageBase.class);
    }


//        @Override
//    public AbstractPage clickOnTab(Tab tab) {
//        elementTab.format(tab.getLabel()).click();
//            return initPage(getDriver(), tab.getClassName());
//    }


//    @Override
//    public AbstractPage clickOnTab(Tab tab) {
//        elementTab.format(tab.getLabel()).click();
//    return this;
//    }

}
