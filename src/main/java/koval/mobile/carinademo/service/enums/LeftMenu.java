package koval.mobile.carinademo.service.enums;


import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.carinademo.gui.common.leftMenuPages.ChartsPageBase;
import koval.mobile.carinademo.gui.common.leftMenuPages.MapPageBase;
import koval.mobile.carinademo.gui.common.leftMenuPages.UIElementsPageBase;
import koval.mobile.carinademo.gui.common.leftMenuPages.WebViewPageBase;

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

