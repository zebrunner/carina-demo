package koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage.addFood.tabsCreatePages.myRecipes;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.tabsCreatePages.myRecipes.CreateRecipePageBase;
import koval.mobile.myfitnesspal.service.factories.recipeFactory.Recipe;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreateRecipePageBase.class)
public class CreateRecipePage extends CreateRecipePageBase {

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//*[@content-desc='%s']")
    private ExtendedWebElement itemByContent;

    @FindBy(id = "com.myfitnesspal.android:id/inputName")
    private ExtendedWebElement recipeNameTextBox;

    @FindBy(id = "com.myfitnesspal.android:id/inputServings")
    private ExtendedWebElement servingsNumberTextBox;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement foodTitle;

    @FindBy(id = "com.myfitnesspal.android:id/switchBulkImport")
    private ExtendedWebElement bulkImportSwitch;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/inputIngredients']/child::*[@class='android.widget.EditText'][2]")
    private ExtendedWebElement inputIngredientsTextBox;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/toolbar']/child::*[@class='android.widget.ImageButton']")
    private ExtendedWebElement backToSearchPageButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='SearchRecipeIngredientActivity']/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText")
    private ExtendedWebElement searchIngredientsTextBox;

    public CreateRecipePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return itemByText.format(NEW_RECIPE).isElementPresent(TIMEOUT_FIVE);
    }


    @Override
    public DiaryPageBase createRecipeByEnteringIngredientsPerLine(Recipe recipe) {

        recipeNameTextBox.type(recipe.getRecipeName(), TIMEOUT_FIVE);

        servingsNumberTextBox.type(String.valueOf(recipe.getServings()), TIMEOUT_FIVE);

        if (!bulkImportSwitch.isChecked()) {
            bulkImportSwitch.check();
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < recipe.getRecipeIngredients().size()) {
            sb.append(recipe.getRecipeIngredients().get(i));
            sb.append(SPACE_FIELD);
            i++;
        }
        String recipeIngredientsString = sb.toString();

        inputIngredientsTextBox.type(recipeIngredientsString, TIMEOUT_FIVE);

        hideKeyboard();

        itemByText.format(NEXT).click();
        itemByText.format(NEXT).click();
        itemByText.format(SAVE).click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(itemByText.format(ADD_TO_DIARY_STRING).getBy()), TIMEOUT_FORTY);

        itemByText.format(ADD_TO_DIARY_STRING).click();

        closeTimestampsPopUpIfPresent();

        itemByContent.format(ADD_STRING).click();

        return initPage(getDriver(), DiaryPageBase.class);
    }

    @Override
    public DiaryPageBase createRecipe(String recipeName, int servings, List<String> recipeIngredients) {

        recipeNameTextBox.type(recipeName, TIMEOUT_FIVE);
        servingsNumberTextBox.type(String.valueOf(servings), TIMEOUT_FIVE);

        hideKeyboard();

        itemByText.format(NEXT).click();

        itemByText.format(ADD_INGREDIENTS).click();

        for (int i = 0; i < recipeIngredients.size(); i++) {

            searchIngredientsTextBox.type(recipeIngredients.get(i) + "\\n", TIMEOUT_FIVE);

            foodTitle.format(recipeIngredients.get(i)).click();
            closeTimestampsPopUpIfPresent();
            itemByContent.format(ADD_STRING).click();

            if (i != recipeIngredients.size() - 1) {
                itemByContent.format(ADD_INGREDIENT).click(TIMEOUT_FIVE);
            }
        }

        itemByText.format(NEXT).click();
        itemByText.format(SAVE).click();
        itemByText.format(ADD_TO_DIARY_STRING).click();
        itemByContent.format(ADD_STRING).click();

        return initPage(getDriver(), DiaryPageBase.class);
    }
}
