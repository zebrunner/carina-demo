package koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.myFoods;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.foodDiaryPages.FoodDiaryPage;
import koval.web.myfitnesspal.service.factories.foodFactory.Food;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NutritionalInformationPage extends MyAbstractPage {
    @FindBy(id = "weight_serving_size")
    ExtendedWebElement servingSizeInput;

    @FindBy(id = "servingspercontainer")
    ExtendedWebElement servingsPerContainerInput;

    @FindBy(xpath = "//*[@id=\"buttonPad\"]/input[1]")
    ExtendedWebElement saveButton;


    public NutritionalInformationPage(WebDriver driver) {
        super(driver);
    }


    public NutritionalInformationPage typeServingSize(Food  food)
    {
        servingSizeInput.type(food.getServingSize());
        return new NutritionalInformationPage(driver);
    }

    public NutritionalInformationPage typeServingsPerContainer(Food food)
    {
        servingsPerContainerInput.type(String.valueOf(food.getServingsPerContainer()));
        return new NutritionalInformationPage(driver);
    }


    public FoodDiaryPage clickOnSaveButton()
    {
        saveButton.click();
        return new FoodDiaryPage(driver);
    }


}
