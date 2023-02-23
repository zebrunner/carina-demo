package com.qaprosoft.carina.demo.mobile.gui.web.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.BrandModelsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BrandModelsPageBase.class)
public class BrandModelsPage extends BrandModelsPageBase {
    @FindBy(xpath = "//div[@class='general-menu']//li//strong")
    private List<ExtendedWebElement> models;

    @FindBy(xpath = "//div[@class='cls-btn']")
    private ExtendedWebElement adCloseButton;

    public BrandModelsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ModelInfoPageBase selectModel(String modelName) {
        for (ExtendedWebElement model : models) {
            if (modelName.equalsIgnoreCase(model.getText())) {
                model.click();
                return initPage(driver, ModelInfoPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);

    }

    public void closeAd(){
        adCloseButton.clickIfPresent();
    }
}
