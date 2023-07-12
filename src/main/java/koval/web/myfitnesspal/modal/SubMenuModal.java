package koval.web.myfitnesspal.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import koval.web.myfitnesspal.pages.MyAbstractUIPage;
import koval.web.myfitnesspal.service.enums.menus.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class SubMenuModal extends MyAbstractUIPage {


    public SubMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AbstractPage openPageFromSubMenu(Enum<?> menu) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (menu instanceof FoodMenu) {
            FoodMenu foodMenu = (FoodMenu) menu;
            return openPage(foodMenu.getPageName(), foodMenu.getClassName());
        } else if (menu instanceof ExerciseMenu) {
            ExerciseMenu exerciseMenu = (ExerciseMenu) menu;
            return openPage(exerciseMenu.getPageName(), exerciseMenu.getClassName());
        } else if (menu instanceof MyHomeMenu) {
            throw new NotImplementedException();
        } else if (menu instanceof ReportsMenu) {
            throw new NotImplementedException();
        } else if (menu instanceof AppsMenu) {
            throw new NotImplementedException();
        } else if (menu instanceof CommunityMenu) {
            throw new NotImplementedException();
        } else if (menu instanceof BlogMenu) {
            throw new NotImplementedException();
        } else if (menu instanceof PremiumMenu) {
            throw new NotImplementedException();
        } else {
            throw new IllegalArgumentException(" [SUB MENU] Invalid menu type!");
        }
    }

    private AbstractPage openPage(String pageName, Class<? extends AbstractPage> pageClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        itemByText.format(pageName).click();
        return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }


}
