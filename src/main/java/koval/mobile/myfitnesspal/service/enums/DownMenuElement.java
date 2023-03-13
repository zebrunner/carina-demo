package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.*;

public enum DownMenuElement {
    DASHBOARD("Dashboard", 0, DashboardPageBase.class),
    DIARY("Diary", 1, DiaryPageBase.class),
    NEWSFEED("Newsfeed", 2, NewsfeedPageBase.class),
    PLANS("Plans", 3, PlansPageBase.class);


    public final String pageName;
    public final int pageIndex;
    private final Class<? extends AbstractPage> className;

    DownMenuElement(String pageName, int pageIndex, Class<? extends AbstractPage> className) {
        this.pageName = pageName;
        this.pageIndex = pageIndex;
        this.className = className;
    }


    public String getPageName() {
        return pageName;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
