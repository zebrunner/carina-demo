package koval.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "login-active")
    ExtendedWebElement profileButton;

    @FindBy(xpath = "//*[@class=\"article-info\"]//div/h1[text()=' %s - user account']")
    ExtendedWebElement userAccountText;


    @FindBy(id="topsearch")
    ExtendedWebElement searchBar;

    @FindBy(id="topsearch-text")
    ExtendedWebElement activeSearchBar;

    @FindBy(xpath="//*[@id=\"topsearch\"]/div[2]/a[1]")
    ExtendedWebElement searchButton;



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
        searchButton.click();
        return new SearchResultsPage(driver);
    }


}
