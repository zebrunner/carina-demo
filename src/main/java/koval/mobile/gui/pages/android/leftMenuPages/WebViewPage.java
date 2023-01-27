package koval.mobile.gui.pages.android.leftMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.mobile.gui.pages.service.enums.LeftMenu;
import koval.mobile.gui.pages.service.enums.Topic;
import koval.mobile.gui.pages.service.interfaces.IConstantUtils;
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


    @FindBy(xpath = "//android.view.View[@text='Welcome to CARINA']")
    private ExtendedWebElement firstTopic;

    @FindBy(xpath = "//android.view.View[@text='%s']")
    private ExtendedWebElement topicText;

    @FindBy(xpath = "//android.view.View")
    private List<ExtendedWebElement> listOfTopics;

    @FindBy(xpath = "//android.widget.TextView[@text='support@zebrunner.com']")
    private ExtendedWebElement emailTextElement;

    @FindBy(xpath = "//*[@resource-id='com.solvd.carinademoapplication:id/lin']/child::*//*[@class='android.webkit.WebView']")
    private ExtendedWebElement webViewContainer;

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
    public List<String> getTopicsToListFirst() {
        swipeInContainer(webViewContainer, Direction.UP, COUNT_TWO, MEDIUM_SPEED);
        LOGGER.info(String.valueOf(listOfTopics.get(0).getElement()));

        return listOfTopics.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }


    @Override
    public List<String> getTopicsToList() {

        List<String> listOfTopics = new ArrayList<>();

        swipeInContainer(webViewContainer, Direction.UP, COUNT_TWO, MEDIUM_SPEED);

        listOfTopics.add(topicText.format(Topic.WELCOME_TO_CARINA.getTopicName()).getText());

        swipeInContainer(webViewContainer, Direction.UP, COUNT_TEN, MEDIUM_SPEED);

        listOfTopics.add(topicText.format(Topic.SEAMLESS_INTEGRATION.getTopicName()).getText());

        return listOfTopics;
    }


    @Override
    public String getFirstTopic() {

        swipeInContainer(webViewContainer, Direction.UP, 3, MEDIUM_SPEED);

        return firstTopic.getText();
    }

    @Override
    public List<String> getRightMenuElementsToList() {

        if (listOfMenuElement.isEmpty()) {
            Assert.fail("[WEB VIEW PAGE] List is empty");
        }

        return listOfMenuElement.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public String[] getParsedEmail() {

        swipe(emailTextElement, webViewContainer, Direction.UP, COUNT_THREE, HIGH_SPEED);

        return emailTextElement.getText().split("@");
    }


    @Override
    public String getEmailAgent() {
        swipe(emailTextElement, webViewContainer, Direction.UP, COUNT_THREE, HIGH_SPEED);

        return emailTextElement.getText().substring(emailTextElement.getText().lastIndexOf('@') + 1);
    }

    @Override
    public String getEmailName() {
        swipe(emailTextElement, webViewContainer, Direction.UP, COUNT_THREE, HIGH_SPEED);

        return emailTextElement.getText().substring(0, emailTextElement.getText().lastIndexOf('@'));
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
    public boolean isEmailTextElementPresent(long timeOut) {
        return false;
    }

    @Override
    public boolean isTopicPresent(long timeOut) {
        return false;
    }

    @Override
    public boolean isTopicPresent(Topic topic) {
        return firstTopic.isElementPresent();
    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(LeftMenu.WEB_VIEW.getPageName());
    }


}
