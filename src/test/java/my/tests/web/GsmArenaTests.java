package my.tests.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GsmArenaTests implements IAbstractTest {

    @Test
    public void isHeaderElementPresentTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        Assert.assertTrue(homePage.getHeader().isAllElementsPresent(), "Not all element is presented");
    }
}
