package koval.carinademo.mobile.gui.pages.service.enums;


import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.carinademo.mobile.gui.pages.common.leftMenuPages.ChartsPageBase;
import koval.carinademo.mobile.gui.pages.common.leftMenuPages.MapPageBase;
import koval.carinademo.mobile.gui.pages.common.leftMenuPages.UIElementsPageBase;
import koval.carinademo.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;

public enum LeftMenu{

    WEB_VIEW("Web View", WebViewPageBase.class),

    CHARTS("Charts", ChartsPageBase.class),

    MAP("Map", MapPageBase.class),

    UI_ELEMENTS("UI elements", UIElementsPageBase.class);

    private final String pageName;
    private final Class<? extends AbstractPage> className;

    LeftMenu(String pageName, Class<? extends AbstractPage> className) {
        this.pageName = pageName;
        this.className = className;
    }

    public String getPageName() {
        return pageName;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}

