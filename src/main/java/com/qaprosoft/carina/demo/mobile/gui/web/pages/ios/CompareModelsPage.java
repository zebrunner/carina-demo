package com.qaprosoft.carina.demo.mobile.gui.web.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.CompareModelsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CompareModelsPageBase.class)
public class CompareModelsPage extends CompareModelsPageBase {
    @FindBy(id = "sSearch1")
    private ExtendedWebElement leftInputField;

    @FindBy(id = "sSearch2")
    private ExtendedWebElement rightInputField;

    @FindBy(xpath = "//div[@class='phone-results']//span[text()='%s']//parent::a")
    private ExtendedWebElement searchResult;

    @FindBy(xpath = "//a[text()='Announced']/parent::td//following-sibling::td")
    private List<ExtendedWebElement> announcedFields;

    @FindBy(xpath = "//a[text()='Technology']/parent::td//following-sibling::td")
    private List<ExtendedWebElement> technologyFields;

    public CompareModelsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<ModelSpecs> compareModels(String firstModel, String secondModel) {
        List<ModelSpecs> modelSpecs = new ArrayList<>();
        openModelSpecs(leftInputField, firstModel);
        openModelSpecs(rightInputField, secondModel);

        ModelSpecs modelSpec1 = new ModelSpecs();
        modelSpec1.setToModelSpecsMap(ModelSpecs.SpecType.ANNOUNCED, announcedFields.get(0).getText());
        modelSpec1.setToModelSpecsMap(ModelSpecs.SpecType.TECHNOLOGY, technologyFields.get(0).getText());

        ModelSpecs modelSpec2 = new ModelSpecs();
        modelSpec2.setToModelSpecsMap(ModelSpecs.SpecType.ANNOUNCED, announcedFields.get(1).getText());
        modelSpec2.setToModelSpecsMap(ModelSpecs.SpecType.TECHNOLOGY, technologyFields.get(0).getText());

        modelSpecs.add(modelSpec1);
        modelSpecs.add(modelSpec2);
        return modelSpecs;
    }

    private void openModelSpecs(ExtendedWebElement searchField, String modelName) {
        searchField.type(modelName);
        searchResult.format(modelName).click();
    }
}
