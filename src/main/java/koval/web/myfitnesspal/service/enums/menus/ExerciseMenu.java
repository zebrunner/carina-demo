package koval.web.myfitnesspal.service.enums.menus;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.Database;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.ExerciseDiary;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.myExercise.MyExercises;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.myhomeMenu.SettingsPage;

public enum ExerciseMenu {

    EXERCISE_DIARY("Exercise Diary", ExerciseDiary.class),
    DATABASE("Database", Database.class),
    MY_EXERCISES("My Exercises", MyExercises.class),
    SETTINGS("Settings", SettingsPage.class);


    private final String pageName;
    private final Class<? extends MyAbstractPage> className;

    ExerciseMenu(String pageName, Class<? extends MyAbstractPage> className) {
    this.pageName = pageName;
    this.className= className;
    }

    public String getPageName() {
        return pageName;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
