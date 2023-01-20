package koval;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.leftMenuPages.*;
import koval.mobile.gui.pages.service.enums.Menu;
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
    @TestLabel(name = "1. Open Web View Page and then each page from the menu", value = {"mobile"})
    public void testOpeningPages() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        MenuPageBase basePage = initPage(getDriver(), MenuPageBase.class);
        basePage.openMenu();
        //webViewPageBasePage.openMenu();

        for (Menu menu : Menu.values()) {
            Assert.assertTrue(webViewPageBasePage.isMenuElementPresent(menu), String.format("[ WEB VIEW  ] '%s' page is not present!", menu));
        }
       /*
        Open MAP PAGE
        check if it opens/ map image is present
         */
        MapPageBase mapPageBase = (MapPageBase) webViewPageBasePage.openPage(Menu.MAP);

        Assert.assertTrue(mapPageBase.isPageOpened(), "[ MAP PAGE ] Map page is not opened!");
        Assert.assertTrue(mapPageBase.isMapImagePresent(), "[ MAP PAGE ] Map Image is not present!");
        /*
        Open CHARTS PAGE
        check if it opens/ venn diagram is present
         */
       // mapPageBase.openMenu();
        basePage.openMenu();

        ChartsPageBase chartsPageBase = (ChartsPageBase) webViewPageBasePage.openPage(Menu.CHARTS);

        Assert.assertTrue(chartsPageBase.isPageOpened(), "[ CHARTS PAGE ] Charts page is not opened!");
        Assert.assertTrue(chartsPageBase.isVennDiagramPresent(), "[ CHARTS PAGE ] Venn Diagram is not present!");
         /*
        Open UI ELEMENTS PAGE
        check if it opens/ Profile Image is present
         */
        //chartsPageBase.openMenu();
        basePage.openMenu();

        UIElementsPageBase elementsPageBase = (UIElementsPageBase) webViewPageBasePage.openPage(Menu.UI_ELEMENTS);

        Assert.assertTrue(elementsPageBase.isPageOpened(), "[ UI ELEMENTS PAGE ] UI elements page is not opened!");
        Assert.assertTrue(elementsPageBase.isProfileImagePresent(), "[ UI ELEMENTS PAGE ] Profile Image is not present!");
        /*
        Open WEB VIEW PAGE
        check if it opens/ Web View Image is present
         */
       // elementsPageBase.openMenu();
        basePage.openMenu();

        WebViewPageBase webViewPageBase = (WebViewPageBase) webViewPageBasePage.openPage(Menu.WEB_VIEW);
        Assert.assertTrue(webViewPageBase.isPageOpened(), "[ WEB VIEW PAGE ] Web View page is not opened!");
        Assert.assertTrue(webViewPageBase.isElementPresent(), "[ WEB VIEW PAGE ] Web View Image is not present!");

    }
}
