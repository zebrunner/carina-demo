package koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage.addFood.tabsCreatePages.myMeals;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.tabsCreatePages.myMeals.CopyMealPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CopyMealPageBase.class)
public class CopyMealPage extends CopyMealPageBase {

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//*[@content-desc='%s']")
    private ExtendedWebElement itemByContent;

    public CopyMealPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemByText.format(ADD_MEAL).isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public DiaryPageBase copyMeal() {

        itemByContent.format(ADD_STRING).click();

        return initPage(getDriver(), DiaryPageBase.class);
    }

}
