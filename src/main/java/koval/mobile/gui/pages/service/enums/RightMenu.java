package koval.mobile.gui.pages.service.enums;


import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.common.leftMenuPages.ChartsPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.MapPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.UIElementsPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;

public enum RightMenu {

    READ_ON_GITHUB("Read on GitHub"),

    INSTALLATION_GUIDE("Installation Guide"),

    GO_TO_ZEBRUNNER("Go to Zebrunner"),

    DONATE("Donate"),

 //   DONjATE("Donkate"),

    CONTACT_US("Contact Us");

    private final String pageName;


    RightMenu(String pageName) {
        this.pageName = pageName;
    }

    public String getPageName() {
        return pageName;
    }

}

