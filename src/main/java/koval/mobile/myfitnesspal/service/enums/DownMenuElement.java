package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.*;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;


public enum DownMenuElement {
    DASHBOARD(L10N.getText("dashboard"), "dashboard", 0, DashboardPageBase.class),

    DIARY(L10N.getText("diary"), "diary", 1, DiaryPageBase.class),

    NEWSFEED(L10N.getText("newsfeed"), "newsfeed", 2, NewsfeedPageBase.class),

    PLANS(L10N.getText("plans"), "plans", 3, PlansPageBase.class),

    MORE(L10N.getText("more"), "more", 4, MorePageBase.class),;


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
        return pageName;
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
