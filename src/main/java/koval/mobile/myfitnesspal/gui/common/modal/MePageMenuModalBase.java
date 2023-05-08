package koval.mobile.myfitnesspal.gui.common.modal;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.service.enums.MePageMenuTab;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public abstract class MePageMenuModalBase extends MyAbstractPageBase {

    public MePageMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public MePageMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract MePageBase openTabByName(MePageMenuTab mePageMenuTab);
}
