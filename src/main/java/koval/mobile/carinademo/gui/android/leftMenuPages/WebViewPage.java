package koval.mobile.carinademo.gui.android.leftMenuPages;

import koval.mobile.carinademo.gui.common.leftMenuPages.WebViewPageBase;
import koval.mobile.carinademo.service.interfaces.IConstantUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.carinademo.service.enums.LeftMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)

public class WebViewPage extends WebViewPageBase implements IMobileUtils, IConstantUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@resource-id='allrecords']/child::*[@resource-id='rec40292376']/child::*/*[@class='android.view.View'][1]/child::*[@class='android.widget.TextView'] |" +
            " //*[@resource-id='allrecords']/child::*[@resource-id='rec40368342']/child::*[@class='android.view.View'][2] |" +
            " //*[@resource-id='allrecords']/child::*[@resource-id='rec40091305']/child::*[@class='android.view.View'][1]")
    private ExtendedWebElement topicElements;

    @FindBy(xpath = "//*[@resource-id='allrecords']/child::*[@resource-id='rec40292376']/child::*/*[@class='android.view.View'][1]/child::*[@class='android.widget.TextView'] |" +
            " //*[@resource-id='allrecords']/child::*[@resource-id='rec40368342']/child::*[@class='android.view.View'][2] |" +
            " //*[@resource-id='allrecords']/child::*[@resource-id='rec40091305']/child::*[@class='android.view.View'][1]")
    private List<ExtendedWebElement> listOfTopicElements;

    @FindBy(xpath = "//android.view.View[@content-desc=\"support@zebrunner.com \"]")
    private ExtendedWebElement emailTextElement;

    @FindBy(xpath = "//*[@resource-id='com.solvd.carinademoapplication:id/lin']/child::*//*[@class='android.webkit.WebView']")
    private ExtendedWebElement webViewContainer;

    @FindBy(xpath = "//*[@resource-id='com.solvd.carinademoapplication:id/toolbar']/child::*[@class='android.widget.TextView']")
    private ExtendedWebElement title;

    @FindBy(id = "com.solvd.carinademoapplication:id/content_frame")
    private ExtendedWebElement webViewContent;

    @FindBy(xpath = "//*[@resource-id='t-header']/child::*//*[@class='android.view.View'][2]")
    private ExtendedWebElement rightMenuButton;

    @FindBy(xpath = "//*[@resource-id='nav42972268']/child::*//*[@class='android.widget.TextView']")
    private List<ExtendedWebElement> listOfMenuElement;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getTopicsToList() {

        List<String> listOfTopic = new ArrayList<>();
        int expectedSizeOfListElements = 3;

        while (listOfTopic.size() != expectedSizeOfListElements) {

                swipe(topicElements, MEDIUM_SPEED);

                listOfTopic.add(String.valueOf(listOfTopicElements.get(0).getText()));

                LOGGER.info(listOfTopic.toString());

                while (topicElements.isElementPresent(TIMEOUT_FIVE)) {
                    swipeUp(LOW_SPEED);
                }
        }
        return listOfTopic;
    }

    @Override
    public List<String> getRightMenuElementsToList() {

        if (listOfMenuElement.isEmpty()) {
            Assert.fail("[WEB VIEW PAGE] List is empty");
        }

        return listOfMenuElement.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public String getEmail() {

        swipe(emailTextElement, webViewContainer, Direction.UP, COUNT_THREE, HIGH_SPEED);

        LOGGER.info(emailTextElement.getAttribute("content-desc"));
        return emailTextElement.getAttribute("content-desc");
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
    public boolean isWebViewElementPresent(long timeOut) {
        return webViewContent.isElementPresent(timeOut);

    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(LeftMenu.WEB_VIEW.getPageName());
    }

}
