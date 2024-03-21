package com.qaprosoft.carina.demo.beatsbydre.gui.desktop;

import com.qaprosoft.carina.demo.beatsbydre.component.desktop.Footer;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.RegisterBeatsPageBase;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.resources.L10N;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.desktop.Header;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

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
        footer.getRootExtendedElement().scrollTo();
        return footer;
    }

    @Override
    public void interactWithLocalizedElements() {
        hoverListElements(popularCardsNameList);
        hoverListElements(popularCardsPriceList);
        hoverListElements(featureTitleList);
        hoverListElements(featureDescriptionList);

        headphonesRegisterButton.scrollTo();
        waitUntil(ExpectedConditions.visibilityOf(headphonesRegisterButton.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        L10N.verify(headphonesRegisterButton);
    }

    private void hoverListElements(List<ExtendedWebElement> elementList) {
        elementList.forEach(ExtendedWebElement::hover);
    }

    public RegisterBeatsPageBase toRegisterBeatsPage() {
        headphonesRegisterButton.scrollTo();
        headphonesRegisterButton.scrollTo();
        waitUntil(ExpectedConditions.visibilityOf(headphonesRegisterButton.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        L10N.verify(headphonesRegisterButton);
        headphonesRegisterButton.click();
        return initPage(driver, RegisterBeatsPageBase.class);
    }

    @Override
    public void open() {
        super.open();
    }
}
