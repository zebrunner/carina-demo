package koval.web.myfitnesspal.pages.menuPages.foodMenu.foodDiaryPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.service.enums.Meals;
import koval.web.myfitnesspal.service.factories.foodFactory.Food;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddFoodPage extends MyAbstractPage {
    public AddFoodPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"main\"]/h1")
    ExtendedWebElement title;
    @FindBy(id = "search")
    ExtendedWebElement searchBar;
    @FindBy(xpath = "//*[@id=\"searchFoodByName\"]/form/p/input[4]")
    ExtendedWebElement searchButton;
    @FindBy(xpath = "//div[3]/div/div[2]/div[2]/form/div/div[1]/input[4]")
    ExtendedWebElement addFoodToDiaryButton;
    @FindBy(xpath = "//*[@id='matching']/li[1]")
    ExtendedWebElement firstMatchedFood;

    public boolean isPageOpened(Meals meal) {
        return title.isElementPresent() && title.getText().contains(meal.getMeal());
    }

    public AddFoodPage searchForFood(String food) {
        searchBar.type(food);
        searchButton.click(TIMEOUT_TWENTY);
        return new AddFoodPage(driver);
    }

    public AddFoodPage searchForFood(Food food) {
        searchBar.type(food.getFoodDescription());
        searchButton.click(TIMEOUT_TWENTY);
        return new AddFoodPage(driver);
    }

    public FoodDiaryPage addFoundFood() {
        firstMatchedFood.click();
        addFoodToDiaryButton.click(TIMEOUT_TWENTY);
        return new FoodDiaryPage(driver);
    }

}
