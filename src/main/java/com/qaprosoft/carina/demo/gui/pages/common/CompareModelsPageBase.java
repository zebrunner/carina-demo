package com.qaprosoft.carina.demo.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CompareModelsPageBase extends AbstractPage {
    public CompareModelsPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract List<ModelSpecs> compareModels(String... models);
}
