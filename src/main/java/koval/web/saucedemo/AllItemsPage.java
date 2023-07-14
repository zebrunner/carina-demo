package koval.web.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.saucedemo.modals.MenuModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AllItemsPage extends AbstractPage {


    @FindBy(id = "shopping_cart_container")
    ExtendedWebElement cartButton;

    @FindBy(id = "react-burger-menu-btn")
    MenuModal menuModal;


    public AllItemsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLogged() {
        return menuModal.isUIObjectPresent() &&
                cartButton.isElementPresent();
    }

}
