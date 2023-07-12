package koval.web.myfitnesspal.pages.menuPages.foodMenu;

import koval.web.myfitnesspal.pages.MyAbstractPage;
import org.openqa.selenium.WebDriver;

public class MyFoodsPage extends MyAbstractPage {
    public MyFoodsPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.myfitnesspal.com/food/mine");
    }
}
