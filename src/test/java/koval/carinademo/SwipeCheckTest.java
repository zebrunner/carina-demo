package koval.carinademo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.carinademo.gui.common.leftMenuPages.WebViewPageBase;
import koval.mobile.carinademo.service.interfaces.IConstantUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class SwipeCheckTest extends LoginTest implements IAbstractTest, IMobileUtils, IConstantUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. Open Web View Page and parse mail", value = {"mobile"})
    public void testParseMail() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        String mail = webViewPageBasePage.getEmail();
        String mailName = StringUtils.split(mail, "@")[0];
        String mailAgent = StringUtils.split(mail, "@")[1];

        Assert.assertEquals(mailName, EXPECTED_EMAIL_NAME, "[WEB VIEW] Parsed mail name is wrong!");
        Assert.assertEquals(mailAgent, EXPECTED_EMAIL_AGENT, "[WEB VIEW] Parsed mail agent is wrong!");
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "2. Open Web View Page and get 3 topics to the list(by swiping)", value = {"mobile"})
    public void testGetTopics() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        List<String> actualListOfTopics = webViewPageBasePage.getTopicsToList();

        Assert.assertEquals(actualListOfTopics, EXPECTED_LIST_OF_TOPICS,
                "[ WEB VIEW ] Actual list is not equal to expected list of topics !");

    }

}
