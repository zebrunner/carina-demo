package com.qaprosoft.carina.demo.beatsbydre.locale.generate.gui.desktop;

import com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.desktop.FooterGen;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.desktop.HeaderGen;
import com.qaprosoft.carina.demo.beatsbydre.locale.generate.gui.common.HomePageBaseGen;
import com.zebrunner.carina.utils.factory.DeviceType;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBaseGen.class)
public class HomePageGen extends HomePageBaseGen {

    @FindBy(className = "pdp-header-section")
    private HeaderGen headerGen;

    @FindBy(id = "footercontent")
    private FooterGen footerGen;

    @Localized
    @FindBy(xpath = "//a[contains(@class,'card--large')]//div[@class='card__content-top']//h2")
    private List<ExtendedWebElement> popularCardsNameList;

    @Localized
    @FindBy(xpath = "//a[contains(@class,'card--large')]//div[@class='card__content-top']//div//span")
    private List<ExtendedWebElement> popularCardsPriceList;

    @Localized
    @FindBy(xpath = "//a[contains(@class,'card--custom')]//div[@class='card__content-top']//div")
    private List<ExtendedWebElement> featureTextList;
    public HomePageGen(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderGen getHeader() {
        return headerGen;
    }

    @Override
    public FooterGen getFooterGen() {
        return footerGen;
    }

    @Override
    public List<String> getPopularCardsNames() {
        return popularCardsNameList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public List<String> getPopularCardsPrices() {
        return popularCardsPriceList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public List<String> getFeatureDescriptionList(){
        return featureTextList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }
}
