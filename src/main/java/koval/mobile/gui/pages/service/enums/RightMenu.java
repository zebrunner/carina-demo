package koval.mobile.gui.pages.service.enums;


import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.common.leftMenuPages.ChartsPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.MapPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.UIElementsPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;

public enum RightMenu {

    READ_ON_GITHUB("Read on GitHub", 0),

    INSTALLATION_GUIDE("Installation Guide", 1),

    GO_TO_ZEBRUNNER("Go to Zebrunner", 2),

    DONATE("Donate", 3),

    CONTACT_US("Contact Us", 4);

    private final String pageName;
    private final int pageIndex;

    RightMenu(String pageName, int pageIndex) {
        this.pageName = pageName;
        this.pageIndex = pageIndex;
    }

    public String getPageName() {
        return pageName;
    }

    public int getPageIndex() {
        return pageIndex;
    }

}

