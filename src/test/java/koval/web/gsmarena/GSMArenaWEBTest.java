package koval.web.gsmarena;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.web.gsmarena.modals.LoginModal;
import koval.web.gsmarena.pages.HomePage;
import koval.web.gsmarena.pages.SearchResultsPage;
import koval.web.gsmarena.pages.WelcomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class GSMArenaWEBTest implements IAbstractTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginModal loginModal = welcomePage.clickOnLoginButton();
        HomePage homePage = loginModal.login();
        getDriver().navigate().refresh();
        String userName = R.TESTDATA.get("gsmarena_username");
        Assert.assertTrue(homePage.isUserLogged(userName), String.format("[ HOME PAGE ] user '%s' was not logged!", userName));

    }


    @Test
    @MethodOwner(owner = "dkoval")
    public void searchTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginModal loginModal = welcomePage.clickOnLoginButton();
        HomePage homePage = loginModal.login();
        getDriver().navigate().refresh();

        String itemName = "Samsung";
        SearchResultsPage searchResultsPage = homePage.searchForItem(itemName);
        Assert.assertTrue(searchResultsPage.isPageOpened(itemName),
                String.format("[ SEARCH RESULT PAGE ] Search result page is not opened! item: '%s'", itemName));
        Assert.assertTrue(searchResultsPage.areResultsContainExpectedItems(itemName),
                String.format("[ SEARCH RESULT PAGE ] Search results are not contain expected item: '%s'", itemName));

    }


}
