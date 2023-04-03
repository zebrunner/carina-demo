package com.qaprosoft.carina.demo.ralphlauren.gui.component;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(id = "rlc-ticker-wrapper")
    private HeaderPromotion promotion;

    @FindBy(className = "utility-nav")
    private HeaderRegionNav regionNav;

    @FindBy()
    private HeaderShopNav shopNav;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HeaderPromotion getPromotionHeader() {
        return promotion;
    }

    public HeaderRegionNav getRegionNavHeader() {
        return regionNav;
    }

    public HeaderShopNav getShopNavHeader() {
        return shopNav;
    }
}
