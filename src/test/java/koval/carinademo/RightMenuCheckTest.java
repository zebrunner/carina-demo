package koval.carinademo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.carinademo.mobile.gui.common.BasicPageBase;
import koval.carinademo.mobile.gui.common.leftMenuPages.WebViewPageBase;
import koval.carinademo.mobile.service.enums.RightMenu;
import koval.carinademo.mobile.service.interfaces.IConstantUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class RightMenuCheckTest extends LoginTest implements IAbstractTest, IMobileUtils, IConstantUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. Open Web View Page and then each page from right menu", value = {"mobile"})
    public void testOpeningPages() {


        BasicPageBase pageBase = initPage(getDriver(), BasicPageBase.class);

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        webViewPageBasePage.openMenu();


        //compare enum elements to list with index
        for (RightMenu menu : RightMenu.values()) {
            Assert.assertEquals(webViewPageBasePage.getRightMenuElementsToList().get(menu.getPageIndex()), menu.getPageName(), String.format("[WEB VIEW PAGE] Page '%s' is not present", menu.getPageName()));

        }

        //open second page
       webViewPageBasePage.openPageByIndex(1);

        //return to web view page
        pageBase.getBack();

        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

    }
}
