package com.qaprosoft.carina.demo.beatsbydre.gui.common;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractHeader;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractHeader getHeader();

    public abstract AbstractFooter getFooter();

    public abstract List<String> getPopularCardsNames();

    public abstract List<String> getPopularCardsPrices();

    public abstract List<String> getFeatureTitleList();

    public abstract List<String> getFeatureDescriptionList();

    public abstract String getHeadphonesRegisterButtonText();

    public abstract RegisterBeatsPageBase toRegisterBeatsPage();
}
