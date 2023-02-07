package koval.myfit;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.myfit.mobile.gui.pages.common.menuPages.HomePageBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class GoogleFitTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. Check if Home page is open and Plus button is present while swiping " +
            "/2. Check if Plus-Button is static while swiping->check if Plus-Button is below container at the end", value = {"mobile"})
    public void testPlusButton(){

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        Assert.assertTrue(homePageBase.isPlusBtnStatic(), "[ HOME PAGE ] Plus-Button is not static while swiping");

        int expectedHeightOfContainer = 1790;
        Assert.assertEquals(homePageBase.getContainerHeight(), expectedHeightOfContainer,
                "[ HOME PAGE ] Container is not above plus button!");

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "3. Compare playlist titles and block card topics Lists with expected lists\n", value = {"mobile"})
    public void CompareListOfTopics() {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        List<String> actualMaterialCardTopicsList = homePageBase.getMaterialCardTopicsToList();
        Assert.assertEquals(actualMaterialCardTopicsList, EXPECTED_LIST_OF_MATERIAL_CARD_TOPICS,
                "[ HOME PAGE / actualMaterialCardTopicsList ] Actual list of Material Card topics is not equals to expected list!");

        List<String> actualPlaylistTitlesList = homePageBase.getPlaylistTitlesToList();
        Assert.assertEquals(actualPlaylistTitlesList, EXPECTED_LIST_OF_PLAYLIST_TITLES,
                "[ HOME PAGE / actualPlaylistTitlesList ] Actual list of Playlist titles is not equals to expected list!");

    }
}
