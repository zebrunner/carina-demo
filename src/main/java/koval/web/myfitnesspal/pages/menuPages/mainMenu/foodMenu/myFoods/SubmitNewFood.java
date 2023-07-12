package koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.myFoods;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.service.factories.foodFactory.Food;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubmitNewFood extends AbstractPage {



    @FindBy(xpath = "//*[@id=\"buttonPad\"]/input")
    ExtendedWebElement continueButton;


    @FindBy(id = "food_description")
    ExtendedWebElement foodDescriptionInput;



    @FindBy(xpath = "//*[@id='main']/p[2]/a")
    ExtendedWebElement notDuplicateButton;


    public SubmitNewFood(WebDriver driver) {
        super(driver);
    }

    public SubmitNewFood typeDescription(Food foodDescription)
    {
        foodDescriptionInput.type(foodDescription.getFoodDescription());
        return new SubmitNewFood(driver);
    }

    public NutritionalInformationPage clickOnContinueButton()
    {
        continueButton.click();
        notDuplicateButton.click();
        return new NutritionalInformationPage(driver);
    }



}
