package koval.mobile.carinademo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.carinademo.gui.common.BasicPageBase;
import koval.mobile.carinademo.gui.common.leftMenuPages.WebViewPageBase;
import koval.mobile.carinademo.service.enums.RightMenu;
import koval.mobile.carinademo.service.interfaces.IConstantUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class RightMenuCheckTest extends LoginTest implements IAbstractTest, IMobileUtils, IConstantUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(enabled = false)
    @MethodOwner(owner = "koval")
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
