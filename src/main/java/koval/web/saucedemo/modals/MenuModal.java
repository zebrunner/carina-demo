package koval.web.saucedemo.modals;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuModal extends AbstractUIObject {

    @FindBy(xpath = "//*[@id=\"menu_button_container\"]/div/div[2]/div[1]/nav")
    List <ExtendedWebElement> menuItemList;

    public MenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


}
