package com.qaprosoft.carina.demo.ralphlauren;

import com.qaprosoft.carina.demo.ralphlauren.gui.component.Header;
import com.qaprosoft.carina.demo.ralphlauren.gui.component.HeaderRegionNav;
import com.qaprosoft.carina.demo.ralphlauren.gui.pages.common.HomePageBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocalizationTest extends AbstractBaseTest {

    @Test
    public void ttt() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        pause(10);
        Header header = homePage.getHeader();
        HeaderRegionNav regionNav = header.getRegionNavHeader();
        regionNav.selectLocale("Europe", "Austria", "de");
        pause(10);
    }

}
