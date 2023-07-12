package koval.web.myfitnesspal.pages.menuPages.mainMenu;

import koval.web.myfitnesspal.modal.FoodMenuModal;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class FoodPage extends MyAbstractPage {

    public FoodPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.myfitnesspal.com/food/diary");
    }
    @FindBy(id = "subNav")
    FoodMenuModal foodMenuModal;

    public FoodMenuModal getFoodMenu() {
        return foodMenuModal;
    }



}
