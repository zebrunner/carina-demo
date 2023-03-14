package koval.mobile.myfitnesspal.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;


public abstract class AddFoodPageBase extends MyAbstractPage {

    public AddFoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String mealText);


    public abstract AddFoodPageBase changeMealByName(Meals meals);

    public abstract AddFoodPageBase addFoodToMealByName(String food);

    public abstract DiaryPageBase clickBackButton();
}
