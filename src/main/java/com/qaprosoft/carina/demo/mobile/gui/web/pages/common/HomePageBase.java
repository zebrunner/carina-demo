package com.qaprosoft.carina.demo.mobile.gui.web.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract BrandModelsPageBase selectBrand(String brandName);

    public abstract CompareModelsPageBase openComparePage();

    public abstract NewsPageBase openNewsPage();
}
