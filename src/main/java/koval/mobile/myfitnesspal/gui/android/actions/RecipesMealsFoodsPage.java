package koval.mobile.myfitnesspal.gui.android.actions;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.actions.RecipesMealsFoodsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.service.enums.Items;
import koval.mobile.myfitnesspal.service.enums.RecipeMealsFoods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.ws.rs.DELETE;
import java.util.List;
import java.util.stream.Collectors;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = RecipesMealsFoodsPageBase.class)
public class RecipesMealsFoodsPage extends RecipesMealsFoodsPageBase {

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/tabIndicator']/child::*//*[@content-desc='%s']")
    private ExtendedWebElement tabIndicator;

    @FindBy(id = "com.myfitnesspal.android:id/text_primary")
    private List<ExtendedWebElement> listOfMyFoods;

    @FindBy(id = "com.myfitnesspal.android:id/text_primary")
    private ExtendedWebElement myFoodsTitle;


    @FindBy(id = "com.myfitnesspal.android:id/multiSelectCheckBox")
    private ExtendedWebElement editCheckBox;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='RecipesAndFoods']/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")
    private ExtendedWebElement backButton;




    public RecipesMealsFoodsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public RecipesMealsFoodsPageBase openTabByName(Items items) {

        tabIndicator.format(items.getItemName()).click(TIMEOUT_TEN);
        return initPage(getDriver(), RecipesMealsFoodsPageBase.class);
    }


    @Override
    public RecipesMealsFoodsPageBase deleteAllItemsByName(RecipeMealsFoods recipeMealsFoods) {
        tabIndicator.format(recipeMealsFoods.getItemName()).click(TIMEOUT_TEN);

        while (!listOfMyFoods.isEmpty()) {
            itemByContent.format(MORE_OPTIONS).clickIfPresent(TIMEOUT_TEN);
            itemByText.format(EDIT).click(TIMEOUT_TEN);
            editCheckBox.check();
            itemByContent.format(DELETE).click(TIMEOUT_TEN);
        }

        return initPage(getDriver(), RecipesMealsFoodsPageBase.class);
    }

    @Override
    public MePageBase clickBackButton() {
        backButton.click(TIMEOUT_TEN);
        return initPage(getDriver(), MePageBase.class);
    }


    @Override
    public List<String> getItemElementsToList() {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(myFoodsTitle.getBy()), TIMEOUT_FIFTEEN);


        return listOfMyFoods.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

}