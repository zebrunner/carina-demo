package com.qaprosoft.carina.demo.beatsbydre.locale.generate.gui.common;

import com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.common.AbstractFooterGen;
import com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.common.AbstractHeaderGen;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

import java.util.List;

public abstract class HomePageBaseGen extends AbstractPage {
    public HomePageBaseGen(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractHeaderGen getHeader();

    public abstract AbstractFooterGen getFooterGen();

    public abstract List<String> getPopularCardsNames();

    public abstract List<String> getPopularCardsPrices();

    public abstract List<String> getFeatureDescriptionList();
}
