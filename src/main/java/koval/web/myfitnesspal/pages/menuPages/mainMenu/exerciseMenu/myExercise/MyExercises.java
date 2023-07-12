package koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.myExercise;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyExercises extends MyAbstractPage {
    public MyExercises(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/span/a")
    ExtendedWebElement createExerciseButton;


    public CreateExercise clickOnCreateExerciseButton() {
        createExerciseButton.click();
        return new CreateExercise(driver);
    }

}
