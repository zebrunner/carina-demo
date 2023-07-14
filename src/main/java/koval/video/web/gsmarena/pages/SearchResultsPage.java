package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//*[@class=\"article-info\"]/div[2]//h1[contains(text(), 'Search results for \"%s\"')]")
    ExtendedWebElement title;


    @FindBy(xpath = "//*[@id=\"review-body\"]//ul/li//strong/span")
    List<ExtendedWebElement> listOfResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(String itemName) {
        return title.format(itemName).isElementPresent(20);
    }


    public boolean areResultsContainExpectedItems(String itemName) {

        for (ExtendedWebElement listOfResult : listOfResults) {
            if (!listOfResult.getText().contains(itemName)) {
                return false;
            }
        }
        return true;
    }

}
