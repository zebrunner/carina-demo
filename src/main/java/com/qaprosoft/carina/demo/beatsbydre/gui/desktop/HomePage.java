package com.qaprosoft.carina.demo.beatsbydre.gui.desktop;

import com.qaprosoft.carina.demo.beatsbydre.component.desktop.Footer;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.RegisterBeatsPageBase;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.desktop.Header;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(className = "pdp-header-section")
    private Header header;

    @FindBy(id = "footercontent")
    private Footer footer;

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

    @Localized
    @Context(dependsOn = "registerBeatsContext")
    @FindBy(xpath = ".//div[@class='beats-button']//span[@tabindex]")
    private ExtendedWebElement headphonesRegisterButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public Footer getFooter() {
        return footer;
    }

    @Override
    public List<String> getPopularCardsNames() {
        return popularCardsNameList.stream().filter(ExtendedWebElement::isVisible).map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public List<String> getPopularCardsPrices() {
        return popularCardsPriceList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public List<String> getFeatureTitleList() {
        return featureTitleList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public List<String> getFeatureDescriptionList() {
        return featureDescriptionList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public String getHeadphonesRegisterButtonText() {
        registerBeatsContext.scrollTo();
        waitUntil(ExpectedConditions.visibilityOf(headphonesRegisterButton.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        return headphonesRegisterButton.getText();
    }

    public RegisterBeatsPageBase toRegisterBeatsPage() {
        registerBeatsContext.scrollTo();
        waitUntil(ExpectedConditions.visibilityOf(headphonesRegisterButton.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        headphonesRegisterButton.click();
        return initPage(driver, RegisterBeatsPageBase.class);
    }
}
