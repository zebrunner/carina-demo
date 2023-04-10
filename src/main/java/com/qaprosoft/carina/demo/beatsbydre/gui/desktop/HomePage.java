package com.qaprosoft.carina.demo.beatsbydre.gui.desktop;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractCustomCard;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractLargeCard;
import com.qaprosoft.carina.demo.beatsbydre.component.desktop.CustomCard;
import com.qaprosoft.carina.demo.beatsbydre.component.desktop.Footer;
import com.qaprosoft.carina.demo.beatsbydre.component.desktop.LargeCard;
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

    @FindBy(xpath = "//a[contains(@class,'card--large')]")
    private List<LargeCard> popularCardList;

    @FindBy(xpath = "//a[contains(@class,'card--custom')]")
    private List<CustomCard> featureCardList;

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
    public void interactWithHeadphoneRegBtn() {
        headphonesRegisterButton.scrollTo();
        waitUntil(ExpectedConditions.visibilityOf(headphonesRegisterButton.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        L10N.verify(headphonesRegisterButton);
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
    public List<? extends AbstractLargeCard> getPopularCardsList() {
        return popularCardList;
    }

    public List<? extends AbstractCustomCard> getFeatureCardList() {
        return featureCardList;
    }

    @Override
    public void open() {
        super.open();
    }
}
