package koval.carinademo.mobile.gui.pages.service.enums;


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

    @Override
    public String toString() {
        return pageName;
    }
}

