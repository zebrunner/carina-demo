package koval;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.BasicPageBase;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.mobile.gui.pages.service.enums.RightMenu;
import koval.mobile.gui.pages.service.interfaces.IConstantUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;


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
