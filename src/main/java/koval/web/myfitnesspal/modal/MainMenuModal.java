package koval.web.myfitnesspal.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.MyAbstractUIPage;
import koval.web.myfitnesspal.service.enums.menus.MainMenu;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class MainMenuModal extends MyAbstractUIPage {


    public MainMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AbstractPage openPageFromMenu(MainMenu mainMenuEnum) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        itemByText.format(mainMenuEnum.getPageName()).click();
            return mainMenuEnum.getClassName().getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }

}
