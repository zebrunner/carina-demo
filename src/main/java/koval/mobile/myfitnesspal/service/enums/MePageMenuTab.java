package koval.mobile.myfitnesspal.service.enums;

import com.zebrunner.carina.utils.resources.L10N;

public enum MePageMenuTab {
    MY_INFO("my_info"),
    MY_ITEMS("my_items"),
    MY_POSTS("my_posts");

    public final String tabName;


    MePageMenuTab(String tabName) {
        this.tabName = tabName;
    }


    public String getTabName() {
        return L10N.getText(tabName);
    }

}
