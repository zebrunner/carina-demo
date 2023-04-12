package com.qaprosoft.carina.demo.beatsbydre.gui.ios;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractCustomCard;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractLargeCard;
import com.qaprosoft.carina.demo.beatsbydre.component.ios.CustomCard;
import com.qaprosoft.carina.demo.beatsbydre.component.ios.Footer;
import com.qaprosoft.carina.demo.beatsbydre.component.ios.Header;
import com.qaprosoft.carina.demo.beatsbydre.component.ios.LargeCard;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.HomePageBase;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.RegisterBeatsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.utils.resources.L10N;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.Context;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {
    @FindBy(className = "pdp-header-section")
    private Header header;

    @FindBy(id = "footercontent")
    private Footer footer;

    @FindBy(xpath = "//div[@class='newsletter__section section--collapsed ']//a")
    private ExtendedWebElement newsSubCloseButton;

    @FindBy(xpath = "//a[contains(@class,'card--large')]")
    private List<LargeCard> popularCardList;

    @FindBy(xpath = "//a[contains(@class,'card--custom')]")
    private List<CustomCard> featureCardList;

    @FindBy(xpath = "//div[@class='bbd-1X-image-text-block']")
    private ExtendedWebElement registerBeatsContext;

    @Context(dependsOn = "registerBeatsContext")
    @FindBy(xpath = ".//div[@class='beats-button']//span[@tabindex]")
    private ExtendedWebElement headphonesRegisterButton;

    @FindBy(xpath = "//button[@class='cookie-btn--accept beats-btn beats-btn--button']")
    private ExtendedWebElement acceptCookieButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public Footer getFooter() {
        return footer;
    }

    public void interactWithHeadphoneRegBtn() {
        while (headphonesRegisterButton.getText().isBlank()) {
            swipeUp(DEFAULT_TOUCH_ACTION_DURATION);
        }
        L10N.verify(headphonesRegisterButton);
    }

    private void interactListElements(List<ExtendedWebElement> elementList) {
        for (ExtendedWebElement element : elementList) {
            element.scrollTo();
            element.getText();
        }
    }

    public RegisterBeatsPageBase toRegisterBeatsPage() {
        while (headphonesRegisterButton.getText().isBlank()) {
            swipeUp(DEFAULT_TOUCH_ACTION_DURATION);
        }
        L10N.verify(headphonesRegisterButton);
        headphonesRegisterButton.click();
        return initPage(driver, RegisterBeatsPageBase.class);
    }

    @Override
    public List<? extends AbstractLargeCard> getPopularCardsList() {
        return popularCardList;
    }

    @Override
    public List<? extends AbstractCustomCard> getFeatureCardList() {
        return featureCardList;
    }

    @Override
    public void open() {
        super.open();
        acceptCookieButton.clickIfPresent(5);
        newsSubCloseButton.clickIfPresent();
    }
}
