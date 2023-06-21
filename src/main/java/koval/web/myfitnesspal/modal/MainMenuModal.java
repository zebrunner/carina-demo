package koval.web.myfitnesspal.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.menuPages.FoodPage;
import koval.web.myfitnesspal.service.enums.MainMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MainMenuModal extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[text()='%s']")
    ExtendedWebElement itemByText;

    public MainMenuModal(WebDriver driver) {
        super(driver);
    }

    public FoodPage openPageFromMenu(MainMenu mainMenuEnum) {
        itemByText.format(mainMenuEnum.getPageName()).click();
        return new FoodPage(getDriver());
    }

}
