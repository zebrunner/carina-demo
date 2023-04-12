package com.qaprosoft.carina.demo.beatsbydre.component.desktop;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooterItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

public class FooterItem extends AbstractFooterItem {
    @Localized(focus = Localized.NameFocus.FULL_PATH)
    @FindBy(tagName = "h2")
    private ExtendedWebElement itemTitle;

    @Localized(focus = Localized.NameFocus.FULL_PATH, localeName = "desktopRef")
    @FindBy(xpath = ".//nav//li")
    private List<ExtendedWebElement> subTitles;

    public FooterItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverElements() {
        itemTitle.hover();
        subTitles.forEach(ExtendedWebElement::hover);
    }
}
