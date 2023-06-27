package koval.web.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.resources.L10N;
import koval.web.myfitnesspal.pages.menuPages.*;

public enum MainMenu {

    MY_HOME("MY HOME", HomePage.class),
    FOOD("FOOD", FoodPage.class),
    EXERCISE("EXERCISE", ExercisePage.class),
    REPORTS("REPORTS", ReportsPage.class),
    APPS("APPS", AppsPage.class),
    COMMUNITY("COMMUNITY", CommunityPage.class),
    BLOG("BLOG", BlogPage.class),
    PREMIUM("PREMIUM", PremiumPage.class);


    private final String pageName;
    private final Class<? extends AbstractPage> className;
    MainMenu(String pageName, Class<? extends AbstractPage> className) {
        this.pageName = pageName;
        this.className = className;
    }

    public String getPageName() {
        return L10N.getText(pageName);
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}

