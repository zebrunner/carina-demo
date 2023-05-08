package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals.CreateMealPageBase;

public enum ReturnPages {
    DASHBOARD(DashboardPageBase.class),
    DIARY(DiaryPageBase.class),
    CREATE_A_MEAL(CreateMealPageBase.class);

    private final Class<? extends AbstractPage> className;

    ReturnPages(Class<? extends AbstractPage> className) {
        this.className = className;
    }


    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
