package koval.mobile.myfit.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.android.modal.DownMenuModal;
import koval.mobile.myfit.gui.common.downMenuPages.BrowsePageBase;
import koval.mobile.myfit.gui.android.modal.ManageAccountModal;
import koval.mobile.myfit.service.enums.BrowseMenuElement;
import koval.mobile.myfit.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BrowsePageBase.class)
public class BrowsePage extends BrowsePageBase {

    public BrowsePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[contains(@resource-id, 'category_buttons')]/child::*[@class='android.widget.Button']")
    private List<ExtendedWebElement> listOfCategory;

    @FindBy(id = "com.google.android.apps.fitness:id/og_apd_internal_image_view")
    private ManageAccountModal accountImageModal;

    @FindBy(id = "com.google.android.apps.fitness:id/bottom_navigation")
    private DownMenuModal downMenuModal;


    @Override
    public AbstractPage openCategoryByName(BrowseMenuElement browseMenuElement) {

        if (listOfCategory.isEmpty()) {
            Assert.fail("List of Browse Menu Element is empty!");
        }

        listOfCategory.get(browseMenuElement.getPageIndex()).click();

        return initPage(getDriver(), browseMenuElement.getClassName());
    }


    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        return downMenuModal.openPageByName(downMenuElement);
    }


    @Override
    public int getAccountImageColor() throws IOException {

        return accountImageModal.getAccountImageColor();
    }

}
