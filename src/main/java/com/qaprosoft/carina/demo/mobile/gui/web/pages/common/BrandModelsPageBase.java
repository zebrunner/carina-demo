package com.qaprosoft.carina.demo.mobile.gui.web.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BrandModelsPageBase extends AbstractPage {
    public BrandModelsPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract ModelInfoPageBase selectModel(String modelName);

    public abstract void closeAd();
}
