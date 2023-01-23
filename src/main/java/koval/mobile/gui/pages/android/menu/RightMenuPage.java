package koval.mobile.gui.pages.android.menu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.menu.RightMenuPageBase;
import koval.mobile.gui.pages.service.enums.RightMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import static koval.mobile.gui.pages.service.interfaces.IConstantUtils.TIMEOUT_FIVE;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = RightMenuPageBase.class)
public class RightMenuPage extends RightMenuPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@resource-id='rec42972268']/child::*")
    private ExtendedWebElement rightMenuButton;


    @FindBy(xpath = "//android.webkit.WebView[@scrollable='true']")
    private ExtendedWebElement webViewContent;


    @FindBy(xpath = "//android.widget.TextView[@text = '%s']")
    private ExtendedWebElement menuElement;

    public RightMenuPage(WebDriver driver) {
        super(driver);
    }


//    @Override
//    public List<String> getRightMenuElementsToList(RightMenu menu) {
//
//        List<String> leftMenuItemsList = new ArrayList<>();
//        leftMenuItemsList.add(menuElement.format(menu.getPageName()).getText());
//        LOGGER.info(leftMenuItemsList.toString());
//        //LOGGER.info(menuElement.format(menu.getPageName()).getText());
//        return leftMenuItemsList;
//    }
//
//
//    @Override
//    public boolean isRightMenuContainsAllElements(RightMenu menu) {
//
//        if (getRightMenuElementsToList(menu).size() == RightMenu.values().length) {
//            return true;
//        }
//
//        LOGGER.info("Not completed list");
//
//        return false;
//    }


    @Override
    public boolean isRightMenuContainsAllElements() {

        List<String> leftMenuItemsList = new ArrayList<>();
        List<String> enumList = new ArrayList<>();

       // webViewContent.scrollTo();

        for (RightMenu menu : RightMenu.values()) {
        Assert.assertTrue(menuElement.format(menu.getPageName()).isElementPresent(TIMEOUT_FIVE),
                "[ WEB VIEW, LEFT MENU ] There is no element: " + menu.getPageName());
        leftMenuItemsList.add(menuElement.format(menu.getPageName()).getText());

        enumList.add(menu.getPageName());

//            if(menuElement.format(menu.getPageName()).isElementPresent(TIMEOUT_FIVE))
//                leftMenuItemsList.add(menuElement.format(menu.getPageName()).getText());
//            else {
//                LOGGER.info("There is no element: " + menu.getPageName());
//                //return false;
//            }
        }

        LOGGER.info("list of menu items: " + leftMenuItemsList);
        LOGGER.info("list of enum items: " + enumList);

        if (leftMenuItemsList.size() == RightMenu.values().length) {
            return true;
        }
        else{
            enumList.removeAll(leftMenuItemsList);
        }
        LOGGER.info("Menu does not have this item/s: " + enumList);

        return false;
    }

    @Override
    public RightMenuPageBase openMenu() {
        rightMenuButton.click();
        return initPage(getDriver(), RightMenuPageBase.class);
    }

    @Override
    public RightMenuPageBase openPage(RightMenu menu) {
        menuElement.format(menu.getPageName()).click();
        return initPage(getDriver(), RightMenuPageBase.class);
    }

    @Override
    public boolean isElementPresent(RightMenu menu) {
        return menuElement.format(menu.getPageName()).isElementPresent(TIMEOUT_FIVE);
    }

//    @Override
//    public boolean isElementSelected(RightMenu menu) {
//        return menuElement.format(menu.getPageName()).;
//    }

}
