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
import koval.mobile.gui.pages.service.enums.LeftMenu;
import koval.mobile.gui.pages.service.enums.RightMenu;
import koval.mobile.gui.pages.service.enums.Topic;
import koval.mobile.gui.pages.service.interfaces.IConstantUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class SwipeCheckTest extends LoginTest implements IAbstractTest, IMobileUtils, IConstantUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. Open Web View Page and parse mail", value = {"mobile"})
    public void testParseMail() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        Assert.assertEquals(webViewPageBasePage.getParsedEmail(), ExpectedEmailParts, "[WEB VIEW] Parts of mail was parsed wrong!");

    }
    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "2. Open Web View Page and parse mail", value = {"mobile"})
    public void testParseMailSecond() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        Assert.assertEquals(webViewPageBasePage.getEmailName(), EXPECTED_EMAIL_NAME, "[WEB VIEW] Parsed mail name is wrong!");
        Assert.assertEquals(webViewPageBasePage.getEmailAgent(), EXPECTED_EMAIL_AGENT, "[WEB VIEW] Parsed mail agent is wrong");

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "3. Open Web View Page and get first topic", value = {"mobile"})
    public void testGetFirstTopic() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        Assert.assertEquals(webViewPageBasePage.getFirstTopic(), Topic.WELCOME_TO_CARINA.getTopicName(),
                "[WEB VIEW PAGE] Topic 'WELCOME_TO_CARINA' is not present");

    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "4. Open Web View Page and get topics name by swiping", value = {"mobile"})
    public void testGetAllTopics() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        for (Topic topic : Topic.values()) {
            Assert.assertEquals(webViewPageBasePage.getTopicsToList().get(topic.getTopicIndex()), topic.getTopicName(),
                    String.format("[WEB VIEW PAGE] Topic '%s' is not present", topic.getTopicName()));
        }
    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "6. Open Web View Page and get topics name by swiping", value = {"mobile"})
    public void test() {

        WebViewPageBase webViewPageBasePage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPageBasePage.isPageOpened(), "[ WEB PAGE ] Page is not opened!");

        webViewPageBasePage.getTopicsToListFirst();

    }
}
