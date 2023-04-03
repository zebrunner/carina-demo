package com.qaprosoft.carina.demo.ralphlauren.gui.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPromotion extends AbstractUIObject {

    @FindBy(className = "rlc-slide swiper-slide rlc-ticker-item swiper-slide-active")
    private HeaderPromotion activePromotion;

    @Context(dependsOn = "activePromotion")
    @FindBy(tagName = "a")
    private List<ExtendedWebElement> promotionLinks;

    protected HeaderPromotion(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
