package koval.myfit.mobile.gui.android.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.myfit.mobile.gui.common.modal.DownMenuModalBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = DownMenuModalBase.class)
public class DownMenuModal extends DownMenuModalBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.google.android.apps.fitness:id/navigation_bar_item_icon_view")
    private List<ExtendedWebElement> listOfDownMenuIconElement;

    @FindBy(id = "com.google.android.apps.fitness:id/navigation_bar_item_large_label_view")
    private ExtendedWebElement listOfDownMenuLabelsElement;

    @FindBy(id = "com.google.android.apps.fitness:id/bottom_navigation")
    private ExtendedWebElement downMenu;


    public DownMenuModal(WebDriver driver) {
        super(driver);
    }

    public DownMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public AbstractPage openPageByName(DownMenuElement downMenuElement) {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(downMenu.getBy()), FIVE);

        if (listOfDownMenuIconElement.isEmpty()) {
            Assert.fail("List of Down-Menu Element is empty!");
        }

        listOfDownMenuIconElement.get(downMenuElement.getPageIndex()).click();

        return initPage(getDriver(), downMenuElement.getClassName());
    }


    @Override
    public String getIconColor(DownMenuElement downMenuElement) throws IOException {

        return getColorByName(listOfDownMenuIconElement.get(downMenuElement.getPageIndex()));
    }


    @Override
    public String getLabelColor(DownMenuElement downMenuElement) throws IOException {

        if (!listOfDownMenuLabelsElement.getText().equals(downMenuElement.getPageName())) {
            Assert.fail(String.format("[ DOWN MENU MODAL ] Label '%s' is not present!", downMenuElement.getPageName()));
        }
        return getColorByName(listOfDownMenuLabelsElement);
    }

}
