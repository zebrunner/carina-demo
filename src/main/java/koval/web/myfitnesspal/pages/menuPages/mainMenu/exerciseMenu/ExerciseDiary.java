package koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.service.factories.exerciseFactory.Exercise;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ExerciseDiary extends MyAbstractPage {

    @FindBy(className = "icon-minus-sign")
    ExtendedWebElement deleteButton;

    @FindBy(xpath = "//*[@class=\"first alt\"]//child::a")
    ExtendedWebElement firstExercise;


    public ExerciseDiary(WebDriver driver) {
        super(driver);
    }

    public boolean isExerciseAdded(Exercise exercise) {
        return firstExercise.getText().equals(exercise.getDescription());
    }


    public ExerciseDiary deleteAllExercises() {
        int attemp = 5;
        while (deleteButton.isElementPresent(TIMEOUT_TWENTY) && attemp > 0) {
            deleteButton.click();
            attemp--;
        }
        return new ExerciseDiary(driver);
    }

}
