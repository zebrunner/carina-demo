package com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.desktop;

import java.util.List;

import com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.common.AbstractHeaderGen;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

public class HeaderGen extends AbstractHeaderGen {
    @Localized
    @FindBy(xpath = ".//div[@class='header-container']//li[@role='presentation']/a")
    private List<ExtendedWebElement> headerItems;

    @Localized
    @FindBy(className = "show-desktop")
    private ExtendedWebElement promoText;

    public HeaderGen(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverHeaderItems(){
        for (ExtendedWebElement element: headerItems) {
            element.hover();
        }

        promoText.hover();
    }
}
