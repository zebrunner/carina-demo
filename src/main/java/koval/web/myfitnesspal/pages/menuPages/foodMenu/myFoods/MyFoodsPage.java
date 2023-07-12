package koval.web.myfitnesspal.pages.menuPages.foodMenu.myFoods;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.service.factories.foodFactory.Food;
import koval.web.myfitnesspal.modal.FoodMenuModal;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyFoodsPage extends MyAbstractPage {

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/p")
    ExtendedWebElement firstCreatedFood;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div/div/div/div[1]/div[2]/a/button")
    ExtendedWebElement createFoodButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div/div/div/div[2]/div[2]/div/div[1]/div[2]/button[2]")
    ExtendedWebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div/button[1]")
    ExtendedWebElement yesButton;

    public MyFoodsPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.myfitnesspal.com/food/mine");
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/header/div[3]/div/div")
    FoodMenuModal foodMenuModal;


    public boolean isCreatedFoodAdded(Food foodName) {
        return firstCreatedFood.getText().equals(foodName.getFoodDescription());
    }


    public MyFoodsPage deleteAllFoodButton() {

        while (firstCreatedFood.isElementPresent()) {
            firstCreatedFood.click();
            deleteButton.click();
            yesButton.click();
        }

        return new MyFoodsPage(driver);
    }

    public SubmitNewFood clickOnCreateButton() {
        createFoodButton.click();
        return new SubmitNewFood(driver);
    }

    public FoodMenuModal getFoodMenu() {
        return foodMenuModal;
    }


}
