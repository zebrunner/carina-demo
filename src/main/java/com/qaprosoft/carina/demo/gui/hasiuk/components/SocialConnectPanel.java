package com.qaprosoft.carina.demo.gui.hasiuk.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SocialConnectPanel extends AbstractUIObject {

    @FindBy(xpath = "./a[1]")
    private ExtendedWebElement tipUsLink;

    @FindBy(xpath = "./a[2]")
    private ExtendedWebElement youtubeLink;

    @FindBy(xpath = "./a[3]")
    private ExtendedWebElement instagramLink;

    @FindBy(xpath = "./a[4]")
    private ExtendedWebElement newsReviewLink;

    @FindBy(xpath = "./a[5]")
    private ExtendedWebElement arenaEvLink;

    @FindBy(xpath = "./a[6]")
    private ExtendedWebElement merchLink;

    @FindBy(xpath = "./a[7]")
    private ExtendedWebElement logInLink;

    @FindBy(xpath = "./a[8]")
    private ExtendedWebElement signUpLink;

    public SocialConnectPanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isAllElementsPresent() {
        return (isTipUsLinkPresent() && isYoutubeLinkPresent() && isInstagramLinkPresent() && isNewsReviewLinkPresent()
                && isArenaEvLinkPresent() && isMerchLinkPresent() && isLogInLinkPresent() && isSignUpLinkPresent());
    }

    private boolean isTipUsLinkPresent() {
        return tipUsLink.isPresent();
    }

    private boolean isYoutubeLinkPresent() {
        return youtubeLink.isPresent();
    }

    private boolean isInstagramLinkPresent() {
        return instagramLink.isPresent();
    }

    private boolean isNewsReviewLinkPresent() {
        return newsReviewLink.isPresent();
    }

    private boolean isArenaEvLinkPresent() {
        return arenaEvLink.isPresent();
    }

    private boolean isMerchLinkPresent() {
        return merchLink.isPresent();
    }

    private boolean isLogInLinkPresent() {
        return logInLink.isPresent();
    }

    private boolean isSignUpLinkPresent() {
        return signUpLink.isPresent();
    }
}
