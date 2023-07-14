package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "login-active")
    ExtendedWebElement profileButton;

    @FindBy(xpath = "//*[@class=\"article-info\"]/div/div/h1[text()=\" %s - user account\"]")
    ExtendedWebElement userAccountText;

    @FindBy(id="topsearch")
    ExtendedWebElement searchBar;

    @FindBy(id="topsearch-text")
    ExtendedWebElement activeSearchBar;

    @FindBy(xpath="//*[@id=\"topsearch\"]/div/a[1]")
    ExtendedWebElement goButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLogged(String userName) {
        profileButton.click();
        return userAccountText.format(userName).isElementPresent();
    }

    public SearchResultsPage searchForItem(String itemName)
    {
        searchBar.click();
        activeSearchBar.type(itemName);
        goButton.click();
        return new SearchResultsPage(driver);
    }

}
