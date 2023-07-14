package koval.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class SearchResultsPage extends AbstractPage {


    @FindBy(xpath = "//*[@class=\"article-info\"]/div/div/h1[contains(text(), 'Search results for \"%s\"')]")
    ExtendedWebElement title;


    @FindBy(xpath = "//*[@id=\"review-body\"]/div/ul/li/a/strong/span")
    List<ExtendedWebElement> listOfResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(String itemName) {
        return title.format(itemName).isElementPresent(20);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public boolean areResultsContainExpectedItems(String itemName) {
        for (ExtendedWebElement listOfResult : listOfResults) {
            if (!listOfResult.getText().contains(itemName)) {
                return false;
            }
        }
        return true;
    }


}
