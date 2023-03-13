package koval.mobile.myfit.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.common.downMenuPages.BrowsePageBase;
import koval.mobile.myfit.gui.common.downMenuPages.HomePageBase;
import koval.mobile.myfit.gui.common.downMenuPages.JournalPageBase;
import koval.mobile.myfit.gui.common.downMenuPages.ProfilePageBase;

public enum DownMenuElement {
    HOME("Home", 0, HomePageBase.class),
    JOURNAL("Journal", 1, JournalPageBase.class),
    BROWSE("Browse", 2, BrowsePageBase.class),
    PROFILE("Profile", 3, ProfilePageBase.class);


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
