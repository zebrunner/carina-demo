package koval.web.myfitnesspal.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.MyAbstractUIPage;
import koval.web.myfitnesspal.service.enums.FoodMenu;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class FoodMenuModal extends MyAbstractUIPage {

    public FoodMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AbstractPage openPageFromSubMenu(FoodMenu foodMenu)  {
        itemByText.format(foodMenu.getPageName()).click();
        try {
            return foodMenu.getClassName().getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception exception) {
            throw new RuntimeException(exception);

        }
    }
}
