package koval;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.leftMenuPages.*;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.LeftMenu;
import koval.mobile.gui.pages.service.interfaces.IConstantUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class LeftMenuCheckTest extends LoginTest implements IAbstractTest, IMobileUtils, IConstantUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. Open Web View Page and then each page from left menu", value = {"mobile"})
    public void testOpeningPages() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        LeftMenuModalBase menuModalBase = initPage(getDriver(), LeftMenuModalBase.class);
        menuModalBase.openMenu();

        for (LeftMenu menu : LeftMenu.values()) {
            Assert.assertTrue(menuModalBase.isElementPresent(menu),
                    String.format("[ WEB VIEW  ] '%s' page is not present!", menu));
        }
       /*
        Open MAP PAGE
        check if it opens/ map image is present
         */
        MapPageBase mapPageBase = (MapPageBase) menuModalBase.openPage(LeftMenu.MAP);

        Assert.assertTrue(mapPageBase.isPageOpened(), "[ MAP PAGE ] Map page is not opened!");
        Assert.assertTrue(mapPageBase.isMapImagePresent(), "[ MAP PAGE ] Map Image is not present!");
        /*
        Open CHARTS PAGE
        check if it opens/ venn diagram is present
         */
        ChartsPageBase chartsPageBase = (ChartsPageBase) menuModalBase.openPage(LeftMenu.CHARTS);

        Assert.assertTrue(chartsPageBase.isPageOpened(), "[ CHARTS PAGE ] Charts page is not opened!");
        Assert.assertTrue(chartsPageBase.isVennDiagramPresent(), "[ CHARTS PAGE ] Venn Diagram is not present!");
         /*
        Open UI ELEMENTS PAGE
        check if it opens/ Profile Image is present
         */
        UIElementsPageBase elementsPageBase = (UIElementsPageBase) menuModalBase.openPage(LeftMenu.UI_ELEMENTS);

        Assert.assertTrue(elementsPageBase.isPageOpened(), "[ UI ELEMENTS PAGE ] UI elements page is not opened!");
        Assert.assertTrue(elementsPageBase.isProfileImagePresent(), "[ UI ELEMENTS PAGE ] Profile Image is not present!");
        /*
        Open WEB VIEW PAGE
        check if it opens/ Web View Image is present
         */
        WebViewPageBase webViewPageBase = (WebViewPageBase) menuModalBase.openPage(LeftMenu.WEB_VIEW);
        Assert.assertTrue(webViewPageBase.isPageOpened(), "[ WEB VIEW PAGE ] Web View page is not opened!");
        Assert.assertTrue(webViewPageBase.isElementPresent(), "[ WEB VIEW PAGE ] Web View Image is not present!");

    }
}
