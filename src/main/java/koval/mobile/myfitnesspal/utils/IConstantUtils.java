package koval.mobile.myfitnesspal.utils;


import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;

import java.util.Arrays;
import java.util.List;

import static koval.mobile.myfitnesspal.gui.android.loginPages.WelcomePage.getText;

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

    int TIMEOUT_FIFTY = 50;


    int TIMEOUT_TEN = 10;

    int TIMEOUT_TWENTY = 20;

    int TIMEOUT_FORTY = 40;

    int TWENTY_COUNT = 20;

    int FORTY_COUNT = 40;

    int FIVE_COUNT = 5;

    int FAST_SPEED = 300;


    int MEDIUM_SPEED = 1000;

    int LOW_SPEED = 8000;

    int HOME_PAGE = 3;

    int BACK = 4;

    String SPACE_FIELD = " ";

    String EMPTY_FIELD = "";

    String DOT_AND_COMMA_VALUE = "[,.]";

    String ONE_VALUE = "one";

    String TWO_VALUE = "two";

    String ADD_STRING = L10N.getText("add");

    String ALLOW_ANSWER = getText("allow");

    String ADD_TO_DIARY_STRING = L10N.getText("add_to_diary");

    String ADD_INGREDIENTS = "Add Ingredients";

    String ADD_INGREDIENT = "Add Ingredient";

    String ADD_MEAL = "Add Meal";

    String CONTINUE = "Continue";

    String NEXT = L10N.getText("next");

    String NEW_RECIPE = L10N.getText("new_recipe");

    String ENDING_PLAN_MESSAGE = "If you join this new plan, your current active plan will end. Do you want to continue?";

    String NO_THANKS_ANSWER = L10N.getText("no_Thanks");

    String NO_THANKS_ADD_NUTRIENT_POP_UP = L10N.getText("no_thanks_nutrient");

    String NO_THANKS = L10N.getText("no_thanks");

    String NUMBERS_ONLY = "[^0-9]";

    String FIND_PLAN = "Find a Plan";

    String PLAN_DETAILS = "Plan Details";

    String LATER = "Later";

    String SAVE = L10N.getText("save");

    String ACCEPT = L10N.getText("accept");

    String CHECKED = "checked";

    String END_PLAN = "End Plan";

    String END = "End";

    String COMPLETE_PLAN = "to complete today";

    String LOGIN = getText("logIn");

    String WATER = L10N.getText("water");

    String GYM_WORKOUT = "Gym Workout";

    String LOADING = "Loading…";

    String SIGNUP = getText("signUp");

    String SET = "Set";

    String SKIP = "Skip";

    String SEARCH_FOR_FOOD = L10N.getText("search_for_a_food");

    String CANCEL = L10N.getText("cancel");

    String CLOSE = L10N.getText("close");

    String SELECT_A_MEAL = "Select a meal.";

    String GO_PREMIUM = L10N.getText("go_premium");

    String CALORIES_STRING = getText("calories");

    String PASSWORD = L10N.getText("password");

    String DELETE = L10N.getText("delete");

    String EDIT = L10N.getText("edit");

    String MORE_OPTIONS = L10N.getText("more_options");

    String EMAIL = "email";

    String SOURCE = "source";

    String GOALS = "goals";

    String AGE = "Age";

    String HEIGHT = "height";

    String CLOSE_APP = L10N.getText("close_app");

    String HOME_STRING = L10N.getText("home");

    String WEEKLY_GOAL = "Weekly Goal";

    String WIDGETS_STRING = "Widgets";

    String GOT_IT = L10N.getText("got_it");

    String CURRENT_WEIGHT = "current_weight";

    String INPUT_GOAL_WEIGHT = "inputGoalWeight";

    String NEW_EXERCISE_TEXT = "New Exercise";

    String DO_NOT_ASK_ME_AGAIN = L10N.getText("don't_ask_me_again");

    String EXERCISE_STRING = L10N.getText("exercise");

    String UNITS_VALUE = "units";

    String FITNESSPAL = "MyFitnessPal";

    String CALORIES_WIDGET = "Calories";

    String STRENGTH_TEXT = "Strength";

    String CARDIO_TEXT = "Cardio";

    String YES_ANSWER = L10N.getText("yes");

    String LOG_OUT = L10N.getText("log_out");

    String ACCEPT_CONTINUE = "Accept & continue";

    String TEXT = "text";
    String TAKE_SURVEY = "Take The Survey";

    String NET_CARBS = L10N.getText("net_crabs");

    String USER_AVATAR = "User avatar";

    String PLANS_SURVEY_TITLE = "MyFitnessPal Plans Hub Survey";

    String CONNECT_A_STEP_TRACKER = L10N.getText("connect_a_step_tracker");

    String LOCAL_LANGUAGE = R.CONFIG.get("locale");

    List<String> MY_EXERCISES = Arrays.asList("running", "dancing", "walking", "swimming");

}
