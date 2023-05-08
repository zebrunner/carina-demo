package koval.mobile.myfitnesspal.service.enums;

import com.zebrunner.carina.utils.resources.L10N;

public enum MePageMenuTab {
    MY_INFO(L10N.getText("my_info")),
    MY_ITEMS(L10N.getText("my_items")),
    MY_POSTS(L10N.getText("my_posts"));


    public final String tabName;


    MePageMenuTab(String tabName) {
        this.tabName = tabName;
    }


    public String getTabName() {
        return tabName;
    }

}
