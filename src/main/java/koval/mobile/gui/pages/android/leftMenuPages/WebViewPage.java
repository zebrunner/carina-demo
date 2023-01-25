package koval.mobile.gui.pages.android.leftMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.mobile.gui.pages.service.enums.LeftMenu;
import koval.mobile.gui.pages.service.enums.RightMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import static koval.mobile.gui.pages.service.interfaces.IConstantUtils.TIMEOUT_FIVE;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "com.solvd.carinademoapplication:id/content_frame")
    private ExtendedWebElement webViewContent;

    @FindBy(xpath = "//*[@resource-id='t-header']/child::*//*[@class='android.widget.TextView'][2]")
    private ExtendedWebElement rightMenuButton;

    @FindBy(xpath = "//*[@resource-id='nav42972268']/child::*//*[@class='android.widget.TextView']")
    private List<ExtendedWebElement> listOfMenuElement;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getRightMenuElementsToList() {

        if (listOfMenuElement.isEmpty()) {
            Assert.fail("[WEB VIEW PAGE] List is empty");
        }

        return listOfMenuElement.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }


    @Override
    public List<String> getEnumElementsToList() {
        return EnumSet.allOf(RightMenu.class).stream().map(RightMenu::getPageName).collect(Collectors.toList());
    }


    @Override
    public AbstractPage openPageByIndex(int index) {

        if (listOfMenuElement.isEmpty() || index > listOfMenuElement.size()) {
            Assert.fail(String.format("[ WEB VIEW PAGE, RIGHT MENU] There is no element by index '%s'.", index));
        }

        listOfMenuElement.get(index).click();

        return initPage(getDriver(), WebViewPageBase.class);
    }

    @Override
    public AbstractPage openMenu() {

        rightMenuButton.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }


    @Override
    public boolean isElementPresent() {
        return webViewContent.isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(LeftMenu.WEB_VIEW.getPageName());
    }


}
