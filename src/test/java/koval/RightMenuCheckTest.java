package koval;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.leftMenuPages.ChartsPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.MapPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.UIElementsPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.common.menu.RightMenuPageBase;
import koval.mobile.gui.pages.service.enums.LeftMenu;
import koval.mobile.gui.pages.service.enums.RightMenu;
import koval.mobile.gui.pages.service.interfaces.IConstantUtils;
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

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        RightMenuPageBase rightMenuPageBase = initPage(getDriver(), RightMenuPageBase.class);
        rightMenuPageBase.openMenu();

//      Assert.assertTrue(rightMenuPageBase.isRightMenuContainsAllElements());
        rightMenuPageBase.isRightMenuContainsAllElements();

        rightMenuPageBase.openPage(RightMenu.CONTACT_US);

        getDriver().navigate().back();

  //      Assert.assertTrue(rightMenuPageBase.isElementSelected(RightMenu.CONTACT_US),
   //             "[ WEB PAGE, LEFT MENU ] Link of opened page is not selected!");

        Assert.assertTrue(rightMenuPageBase.isElementSelected(FOURTH_ELEMENT),
                "[ WEB PAGE, LEFT MENU ] Link Contact Us is not selected!");
    }
}
