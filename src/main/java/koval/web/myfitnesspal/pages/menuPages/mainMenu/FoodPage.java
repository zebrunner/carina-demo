package koval.web.myfitnesspal.pages.menuPages.mainMenu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.modal.FoodMenuModal;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.service.enums.FoodMenu;
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

    public AbstractPage openPageFromSubMenu(FoodMenu foodMenu) {
        itemByText.format(foodMenu.getPageName()).click();
        try {
            return foodMenu.getClassName().getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }


}
