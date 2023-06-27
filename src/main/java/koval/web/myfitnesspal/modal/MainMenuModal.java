package koval.web.myfitnesspal.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.MyAbstractUIPage;
import koval.web.myfitnesspal.service.enums.MainMenu;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class MainMenuModal extends MyAbstractUIPage {


    public MainMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AbstractPage openPageFromMenu(MainMenu mainMenuEnum) {
        itemByText.format(mainMenuEnum.getPageName()).click();
        try {
            return mainMenuEnum.getClassName().getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
