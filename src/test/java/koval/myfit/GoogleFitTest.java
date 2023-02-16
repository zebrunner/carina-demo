package koval.myfit;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.service.enums.MaterialCardTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class GoogleFitTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testPlusButton() {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        Assert.assertTrue(homePageBase.isPlusBtnStatic(), "[ HOME PAGE ] Plus-Button is not static while swiping");

        Assert.assertTrue(homePageBase.isPlusBtnOverElements(), "[ HOME PAGE ] Plus-Button is under element!");
        homePageBase.closePlusButtonMenu();

        Assert.assertTrue(homePageBase.isPlusButtonBelowBlockContainer(), "[ HOME PAGE ] Container is not above plus button!");

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void compareListOfTopics() throws InterruptedException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        TimeUnit.SECONDS.sleep(TIMEOUT_FIVE);

        for (MaterialCardTopics topic : MaterialCardTopics.values()) {
            Assert.assertTrue(homePageBase.isBlockByTitlePresent(topic),
                    String.format("[ HOME PAGE  ] '%s' block with this topic is not present!", topic));
        }

        List<String> EXPECTED_LIST_OF_PLAYLIST_TITLES =
                Arrays.asList("Workout", "Yoga", "Dance", "Meditate", "Mental Health", "Sleep");
        List<String> actualPlaylistTitlesList = homePageBase.getPlaylistTitlesToList();
        Assert.assertEquals(actualPlaylistTitlesList, EXPECTED_LIST_OF_PLAYLIST_TITLES,
                "[ HOME PAGE / actualPlaylistTitlesList ] Actual list of Playlist titles is not equals to expected list!");

    }
}
