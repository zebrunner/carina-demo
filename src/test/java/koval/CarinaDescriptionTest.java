package koval;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.*;
import koval.mobile.gui.pages.service.enums.Gender;
import koval.mobile.gui.pages.service.enums.Tab;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CarinaDescriptionTest implements IAbstractTest, IMobileUtils {

    static final Gender FEMALEGENDER = Gender.FEMALE;

    @BeforeMethod
    public void login()
    {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.typeName("Diana");
        loginPageBase.typePassword(R.CONFIG.get("password"));
        loginPageBase.selectGender(FEMALEGENDER);
        loginPageBase.checkPrivacyPolicyCheckbox();
        loginPageBase.clickLoginBtn();
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. Open Carina Description Page and then each page from burger " +
            "menu(Pages:WebView, Charts, Map, UI elements)", value = {"mobile"})
    public void testOpeningPages() {

        CarinaDescriptionPageBase carinaDescriptionPage = initPage(getDriver(), CarinaDescriptionPageBase.class);
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(),"[ CARINA DESCRIPTION PAGE ] Page is not opened!");

        /*
        Open MAP PAGE
        check if it opens/ map image is present
         */
        carinaDescriptionPage.clickOnBurgerMenu();

        for(Tab tab: Tab.values())
            Assert.assertTrue(carinaDescriptionPage.isSelectedElementPresent(tab), "[ CARINA DESCRIPTION PAGE  ] " +
                    "One or more tabs is not present!");

        MapPageBase mapPageBase = (MapPageBase) carinaDescriptionPage.clickOnTab(Tab.MAP);

        Assert.assertTrue(mapPageBase.isPageOpened(), "[ MAP PAGE ] Map page is not opened!");
        Assert.assertTrue(mapPageBase.isMapImagePresent(), "[ MAP PAGE ] Map Image is not present!");

        /*
        Open CHARTS PAGE
        check if it opens/ chart is present
         */
        carinaDescriptionPage.clickOnBurgerMenu();

        for(Tab tab: Tab.values())
            Assert.assertTrue(carinaDescriptionPage.isSelectedElementPresent(tab), "[ MAP PAGE  ] " +
                    "One or more tabs is not present!");


        ChartsPageBase chartsPageBase = (ChartsPageBase) carinaDescriptionPage.clickOnTab(Tab.CHARTS);

        Assert.assertTrue(chartsPageBase.isPageOpened(), "[ CHARTS PAGE ] Charts page is not opened!");
        Assert.assertTrue(chartsPageBase.isVennChartPresent(), "[ CHARTS PAGE ] Chart element is not present!");

         /*
        Open UI ELEMENTS PAGE
        check if it opens/  is present
         */
        carinaDescriptionPage.clickOnBurgerMenu();

        for(Tab tab: Tab.values())
            Assert.assertTrue(carinaDescriptionPage.isSelectedElementPresent(tab), "[ CHARTS PAGE  ] " +
                    "One or more tabs is not present!");


        UIElementsPageBase elementsPageBase = (UIElementsPageBase) carinaDescriptionPage.clickOnTab(Tab.UI_ELEMENTS);

        Assert.assertTrue(elementsPageBase.isPageOpened(), "[ UI ELEMENTS PAGE ] UI elements page is not opened!");
        Assert.assertTrue(elementsPageBase.isImageViewPresent(), "[ UI ELEMENTS PAGE ] UI elements Image is not present!");

        /*
        Open WEB VIEW PAGE(CARINA DESCRIPTION PAGE)
        check if it opens/  is present
         */
        carinaDescriptionPage.clickOnBurgerMenu();

        for(Tab tab: Tab.values())
            Assert.assertTrue(carinaDescriptionPage.isSelectedElementPresent(tab), "[ UI ELEMENTS PAGE ] " +
                    "One or more tabs is not present!");

        //WebViewPageBase  webViewPageBase = (WebViewPageBase) carinaDescriptionPage.clickOnTab(Tab.WEB_VIEW);
        CarinaDescriptionPageBase  webViewPageBase = (CarinaDescriptionPageBase) carinaDescriptionPage.clickOnTab(Tab.WEB_VIEW);

        Assert.assertTrue(webViewPageBase.isPageOpened(), "[ CARINA DESCRIPTION PAGE ] Web View page is not opened!");
        Assert.assertTrue(webViewPageBase.isElementPresent(), "[ CARINA DESCRIPTION PAGE ] Web View Image is not present!");

    }
}
