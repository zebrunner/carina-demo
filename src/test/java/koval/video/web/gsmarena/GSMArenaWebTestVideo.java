package koval.video.web.gsmarena;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.video.web.gsmarena.pages.HomePage;
import koval.video.web.gsmarena.pages.SearchResultsPage;
import koval.video.web.gsmarena.pages.WelcomePage;
import koval.video.web.gsmarena.modals.LoginModal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GSMArenaWebTestVideo implements IAbstractTest {

    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginModal loginModal = welcomePage.clickOnLoginButton();
        HomePage homePage = loginModal.login();
        String userName = R.TESTDATA.get("gsmarena_username");
        Assert.assertTrue(homePage.isUserLogged(userName), String.format("[ HOME PAGE ] User '%s' is not logged!", userName));
    }


    @Test
    @MethodOwner(owner = "dkoval")
    public void searchTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginModal loginModal = welcomePage.clickOnLoginButton();
        HomePage homePage = loginModal.login();

        String itemName = "Samsung";
        SearchResultsPage searchResultsPage = homePage.searchForItem(itemName);
        Assert.assertTrue(searchResultsPage.isPageOpened(itemName),
                String.format("[ SEARCH RESULTS PAGE ] Search results page is not opened! item: %s", itemName));
        Assert.assertTrue(searchResultsPage.areResultsContainExpectedItems(itemName),
                String.format("[ SEARCH RESULTS PAGE ] Search results does not contain item: %s", itemName));

    }


}
