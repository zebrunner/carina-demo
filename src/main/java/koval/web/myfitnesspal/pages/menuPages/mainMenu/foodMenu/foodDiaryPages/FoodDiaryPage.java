package koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.foodDiaryPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.service.enums.Meals;
import koval.web.myfitnesspal.service.factories.foodFactory.Food;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FoodDiaryPage extends MyAbstractPage {
    public FoodDiaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='delete']")
    List<ExtendedWebElement> listOfDeleteFoodButton;

    @FindBy(xpath = "//*[@class='meal_header']//child::*[text()='%s']//following::tr[@class='bottom'][1]//a[@class='add_food']")
    ExtendedWebElement addFoodButtonByText;

    @FindBy(xpath = "//*[@class='meal_header']//child::*[text()='%s']//following::a[contains(text(),'%s')]")
    ExtendedWebElement addedFoodByText;


    public FoodDiaryPage deleteAllFood() {
        int attemp = listOfDeleteFoodButton.size();

        while (!listOfDeleteFoodButton.isEmpty() && attemp > 0) {
            attemp--;
            listOfDeleteFoodButton.get(0).click(TIMEOUT_TWENTY);
        }
        return new FoodDiaryPage(driver);
    }


    public AddFoodPage clickOnAddFoodButton(Meals meal) {
        addFoodButtonByText.format(meal.getMeal()).click();
        return new AddFoodPage(driver);
    }

    public boolean isFoodAdded(Meals meal, Food food) {
        return addedFoodByText.format(meal.getMeal(), food.getFoodDescription()).isElementPresent(TIMEOUT_TWENTY);
    }


}
