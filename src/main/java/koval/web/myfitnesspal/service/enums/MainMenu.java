package koval.web.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.*;


public enum MainMenu {
    MY_HOME("My Home",  HomePage.class),
    FOOD("Food",  FoodPage.class),
    EXERCISE("Exercise",  ExercisePage.class),
    REPORTS("Reports",  ReportsPage.class),
    APPS("Apps",  AppsPage.class),
    COMMUNITY("Community",  CommunityPage.class),
    BLOG("Blog",  BlogPage.class),
    PREMIUM("Premium",  PremiumPage.class);

    private final String pageName;
    private final Class<? extends AbstractPage> className;

    MainMenu(String pageName, Class<? extends AbstractPage> className)
 {
        this.pageName = pageName;
        this.className = className;
    }

    public String getPageName() {
        return pageName;
    }

    public  Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
