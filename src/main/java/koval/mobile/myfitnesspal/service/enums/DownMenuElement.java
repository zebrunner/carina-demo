package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.*;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubPageBase;


public enum DownMenuElement {
    DASHBOARD("dashboard", "dashboard", 0, DashboardPageBase.class),

    DIARY("diary", "diary", 1, DiaryPageBase.class),

    NEWSFEED("newsfeed", "newsfeed", 2, NewsfeedPageBase.class),

    PLANS("plans", "plans", 3, PlansHubPageBase.class),

    MORE("more", "more", 4, MorePageBase.class),;


    public final String pageName;

    public final String pageNameForXpath;
    public final int pageIndex;
    private final Class<? extends AbstractPage> className;

    DownMenuElement(String pageName, String pageNameForXpath, int pageIndex, Class<? extends AbstractPage> className) {
        this.pageName = pageName;
        this.pageNameForXpath = pageNameForXpath;
        this.pageIndex = pageIndex;
        this.className = className;
    }


    public String getPageName() {
        return L10N.getText(pageName);
    }

    public String getPageNameForXpath() {
        return pageNameForXpath;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
