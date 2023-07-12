package koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RecipesPage extends MyAbstractPage {

    @FindBy(xpath = "//*[@class='new_recipe_button']")
    ExtendedWebElement newRecipeButton;

    public RecipesPage(WebDriver driver) {
        super(driver);
    }


}
