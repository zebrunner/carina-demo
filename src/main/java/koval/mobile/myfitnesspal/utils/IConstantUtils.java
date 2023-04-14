package koval.mobile.myfitnesspal.utils;


import java.util.Arrays;
import java.util.List;

import static koval.mobile.myfitnesspal.gui.IMyInterface.adbService;

public interface IConstantUtils {

    int ONE_TIME = 1;

    int MAX_AGE = 40;

    int MIN_AGE = 18;

    int MAX_HEIGHT = 199;

    int MIN_HEIGHT = 160;

    int MAX_WEIGHT = 100;

    int MIN_WEIGHT = 70;

    int TIMEOUT_FIVE = 5;

    int TIMEOUT_TWO = 2;

    int TIMEOUT_FIFTEEN = 15;

    int TIMEOUT_TEN = 10;

    int TIMEOUT_TWENTY = 20;

    int TWENTY_COUNT = 20;

    int MEDIUM_SPEED = 1000;

    int LOW_SPEED = 7000;

    int HOME_PAGE = 3;

    int BACK = 4;

    String SPACE_FIELD = " ";

    String EMPTY_FIELD = "";

    String ONE_VALUE = "one";

    String TWO_VALUE = "two";

    String ADD_STRING = "Add";

    String ALLOW_ANSWER = "Allow";

    String ADD_TO_DIARY_STRING = "Add to Diary";

    String ADD_INGREDIENTS = "Add Ingredients";

    String ADD_INGREDIENT = "Add Ingredient";

    String ADD_MEAL = "Add Meal";

    String CONTINUE = "Continue";

    String CREATE_MEAL = "Create a Meal";

    String CREATE_FOOD_TITLE = "Create Food";

    String NEXT = "Next";

    String NEW_RECIPE = "New Recipe";

    String NO_THANKS_ANSWER = "No Thanks";

    String NUMBERS_ONLY = "[^0-9]";

    String SAVE = "Save";

    String ACCEPT = "Accept";

    String CHECKED = "checked";

    String LOGIN = "Log In";

    String LOADING = "Loading…";

    String SIGNUP = "Sign Up";

    String SET = "Set";

    String SKIP = "Skip";

    String CANCEL = "Cancel";

    String SELECT_A_MEAL = "Select a meal.";

    String GO_PREMIUM = "Go Premium";

    String CALORIES_CARD = "Calories card";

    String EMAIL_ADDRESS = "Email Address";

    String PASSWORD = "Password";

    String EMAIL = "email";

    String SOURCE = "source";

    String GOALS = "goals";

    String AGE = "Age";

    String HEIGHT = "height";

    String HOME_STRING = "Home";

    String WEEKLY_GOAL = "Weekly Goal";

    String WIDGETS_STRING = "Widgets";

    String CURRENT_WEIGHT = "current_weight";

    String INPUT_GOAL_WEIGHT = "inputGoalWeight";

    String DIARY_TEXT = "Diary";

    String SNACKS = "Snacks";

    String DO_NOT_ASK_ME_AGAIN = "Don''t ask me again";

    String EXERCISE_STRING = "Exercise";

    String UNITS_VALUE = "units";

    String FITNESSPAL= "MyFitnessPal";

    String CALORIES_WIDGET = "Calories";

    String CONNECT_A_STEP_TRACKER = "Connect a step tracker";

    List<String> MY_FOOD = Arrays.asList("Milk with honey", "Apple with sugar", "Bread and Butter", "Water with honey");

    int SCREEN_PHYSICAL_DENSITY = adbService.getScreenPhysicalDensity();

}
