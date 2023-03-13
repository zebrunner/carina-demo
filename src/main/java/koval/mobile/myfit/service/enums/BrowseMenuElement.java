package koval.mobile.myfit.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.common.browsePages.VitalsPageBase;

public enum BrowseMenuElement {
    ACTIVITY("Activity", 0, AbstractPage.class),
    BODY_MEASUREMENTS("Body measurements", 1, AbstractPage.class),
    VITALS("Vitals", 2, VitalsPageBase.class),
    NUTRITION("Nutrition", 3, AbstractPage.class),
    SLEEP("Sleep", 4, AbstractPage.class),
    CYCLE_TRACKING("Cycle tracking", 5, AbstractPage.class);


    public final String pageName;
    public final int pageIndex;
    private final Class<? extends AbstractPage> className;

    BrowseMenuElement(String pageName, int pageIndex, Class<? extends AbstractPage> className) {
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
