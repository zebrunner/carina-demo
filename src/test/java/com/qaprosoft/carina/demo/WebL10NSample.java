package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.localizationSample.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class WebL10NSample extends AbstractTest {


    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testLanguages() throws Exception {

        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        String welcomeText = mainPage.initPage();
        String expectedWelcomeText = ResourceBundle.getBundle("l10n.carina_demo").getString("HomePage.welcomeText");

        Assert.assertEquals(welcomeText, expectedWelcomeText);

    }

}
