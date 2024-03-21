package com.qaprosoft.carina.demo.beatsbydre.gui.android;

import java.util.List;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.utils.resources.L10N;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qaprosoft.carina.demo.beatsbydre.component.android.Footer;
import com.qaprosoft.carina.demo.beatsbydre.component.android.Header;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.HomePageBase;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.RegisterBeatsPageBase;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.Context;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(className = "pdp-header-section")
    private Header header;

    @FindBy(id = "footercontent")
    private Footer footer;

    @FindBy(xpath = "//div[@class='newsletter__section section--collapsed ']//a")
    private ExtendedWebElement newsSubCloseButton;

    @Localized
    @FindBy(xpath = "//a[contains(@class,'card--large')]//div[@class='card__content-top']//h2")
    private List<ExtendedWebElement> popularCardsNameList;

    @Localized
    @FindBy(xpath = "//a[contains(@class,'card--large')]//div[@class='card__content-top']//div//span")
    private List<ExtendedWebElement> popularCardsPriceList;

    @Localized
    @FindBy(xpath = "//a[contains(@class,'card--custom')]//div[@class='card__content-top']//div//h2")
    private List<ExtendedWebElement> featureTitleList;

    @Localized
    @FindBy(xpath = "//a[contains(@class,'card--custom')]//div[@class='card__content-top']//div//p")
    private List<ExtendedWebElement> featureDescriptionList;

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

    public void interactWithLocalizedElements() {
        hoverListElements(popularCardsNameList);
        hoverListElements(popularCardsPriceList);
        hoverListElements(featureTitleList);
        hoverListElements(featureDescriptionList);

        headphonesRegisterButton.hover();
        swipe(headphonesRegisterButton);
        L10N.verify(headphonesRegisterButton);
        waitUntil(ExpectedConditions.visibilityOf(headphonesRegisterButton.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        headphonesRegisterButton.hover();
    }

    private void hoverListElements(List<ExtendedWebElement> elementList) {
        for (ExtendedWebElement element : elementList) {
            element.getText();
        }
    }

    public RegisterBeatsPageBase toRegisterBeatsPage() {
        headphonesRegisterButton.hover();
        swipe(headphonesRegisterButton);
        waitUntil(ExpectedConditions.visibilityOf(headphonesRegisterButton.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        L10N.verify(headphonesRegisterButton);
        headphonesRegisterButton.click();
        return initPage(driver, RegisterBeatsPageBase.class);
    }

    @Override
    public void open() {
        super.open();
        acceptCookieButton.clickIfPresent(5);
        newsSubCloseButton.clickIfPresent();
    }
}
