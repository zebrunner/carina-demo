package com.qaprosoft.carina.demo.beatsbydre.gui.common;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractCustomCard;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractHeader;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractLargeCard;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractHeader getHeader();

    public abstract AbstractFooter getFooter();

    public abstract void interactWithHeadphoneRegBtn();

    public abstract RegisterBeatsPageBase toRegisterBeatsPage();

    public abstract List<? extends AbstractLargeCard> getPopularCardsList();

    public abstract List<? extends AbstractCustomCard> getFeatureCardList();
}
