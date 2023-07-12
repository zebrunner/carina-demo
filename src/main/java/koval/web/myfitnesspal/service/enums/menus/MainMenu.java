package koval.web.myfitnesspal.service.enums.menus;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.appsMenu.AppsPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.blogMenu.BlogPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.communityMenu.CommunityPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.ExerciseDiary;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.foodDiaryPages.FoodDiaryPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.myhomeMenu.HomePage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.premiumMenu.PremiumPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.reportsMenu.ReportsPage;


public enum MainMenu {
    MY_HOME("My Home",  HomePage.class),

    FOOD("Food",  FoodDiaryPage.class),

    EXERCISE("Exercise",  ExerciseDiary.class),

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
