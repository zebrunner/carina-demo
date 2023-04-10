package com.qaprosoft.carina.demo.beatsbydre.component.desktop;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooterItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FooterItem extends AbstractFooterItem {
    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(tagName = "h2")
    private ExtendedWebElement itemTitle;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE, localeName = "desktopRef")
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
