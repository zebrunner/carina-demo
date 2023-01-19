package koval.mobile.gui.pages.service.enums;

public enum Tab {
    WEB_VIEW("Web View", "WebViewPageBase"),
    CHARTS("Charts", "ChartsPageBase"),
    MAP("Map", "MapPageBase"),
    UI_ELEMENTS("UI elements", "UIElementsPageBase");

    public final String label;
    public final String className;

    Tab(String label, String className) {
        this.label = label;
        this.className = className;
    }

    public String getLabel() {
        return label;
    }

    public String getClassName() {
        return className;
    }
}

