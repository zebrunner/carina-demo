package koval.myfit.mobile.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.BrowsePageBase;
import koval.myfit.mobile.service.enums.BrowseMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BrowsePageBase.class)
public class BrowsePage extends BrowsePageBase {

    public BrowsePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[contains(@resource-id, 'category_buttons')]/child::*[@class='android.widget.Button']")
    private List<ExtendedWebElement> listOfCategory;


    @Override
    public AbstractPage openCategoryByName(BrowseMenuElement browseMenuElement) {

        if (listOfCategory.isEmpty()) {
            Assert.fail("List of Browse Menu Element is empty!");
        }

        listOfCategory.get(browseMenuElement.getPageIndex()).click();

        return initPage(getDriver(), browseMenuElement.getClassName());
    }

}
