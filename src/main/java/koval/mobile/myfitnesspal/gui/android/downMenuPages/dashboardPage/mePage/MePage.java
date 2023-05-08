package koval.mobile.myfitnesspal.gui.android.downMenuPages.dashboardPage.mePage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.MePageMenuModal;
import koval.mobile.myfitnesspal.gui.common.actions.RecipesMealsFoodsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.service.enums.Items;
import koval.mobile.myfitnesspal.service.enums.MePageMenuTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MePageBase.class)
public class MePage extends MePageBase {

    @FindBy(id = "com.myfitnesspal.android:id/tab_layout")
    private MePageMenuModal menuModal;


    @FindBy(xpath = "//*[contains(@text,'%s')]//following-sibling::*[@resource-id='com.myfitnesspal.android:id/create'] |" +
            "//*[contains(@text,'%s')]//following-sibling::*[@resource-id='com.myfitnesspal.android:id/create']")
    private ExtendedWebElement createButtonByItemName;

    public MePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MePageBase openTabFromMenuByName(MePageMenuTab mePageMenuTab) {

        return menuModal.openTabByName(mePageMenuTab);
    }

    @Override
    public RecipesMealsFoodsPageBase openItemByName(Items items) {

        itemByContainsText.format(items.getItemName(), items.getItemNameSmall()).click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), RecipesMealsFoodsPageBase.class);

    }
    @Override
    public AbstractPage clickCreateButtonByItemName(Items items) {

        createButtonByItemName.format(items.getItemName(), items.getItemNameSmall()).click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), items.getClassName());

    }

    @Override
    public int getItemValueByName(Items items) {

        int itemValue = Integer.parseInt(itemByContainsText.format(items.getItemName(),items.getItemNameSmall()).getText().replaceAll(NUMBERS_ONLY, EMPTY_FIELD));

        LOGGER.info("value of item {} is {}", items.getItemName(), itemValue);
        return itemValue;

    }

}
