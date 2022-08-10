package com.qaprosoft.carina.demo.gui.hasiuk.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//button")
    private ExtendedWebElement linesButton;

    @FindBy(id = "logo")
    private ExtendedWebElement logo;

    @FindBy(id = "nav")
    private ExtendedWebElement navigationPanel;

    @FindBy(id = "social-connect")
    private SocialConnectPanel socialConnectPanel;

    @FindBy(id = "menu")
    private HeaderMenu headerMenu;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isAllElementsPresent() {
        return (isLinesButtonPresent() && isLogoPresent() && isNavigationPanelPresent()
                && socialConnectPanel.isAllElementsPresent() && headerMenu.isAllElementsPresent());
    }

    public SocialConnectPanel getSocialConnectPanel() {
        return socialConnectPanel;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    private boolean isLinesButtonPresent() {
        return linesButton.isPresent();
    }

    private boolean isLogoPresent() {
        return logo.isPresent();
    }

    private boolean isNavigationPanelPresent() {
        return navigationPanel.isPresent();
    }
}
