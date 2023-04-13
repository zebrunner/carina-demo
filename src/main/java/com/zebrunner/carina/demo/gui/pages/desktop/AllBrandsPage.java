/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.AllBrandsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.BrandModelsPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AllBrandsPageBase.class)
public class AllBrandsPage extends AllBrandsPageBase {

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public AllBrandsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    @Override
    public BrandModelsPageBase selectBrand(String brandName){
        brandName = brandName.toUpperCase();
        for (ExtendedWebElement brand: findExtendedWebElements(By.xpath("//div[@class='st-text']//td/a"))){
            if (brand.getText().contains(brandName)){
                brand.click();
                return initPage(driver, BrandModelsPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open brand page: " + brandName);
    }

}
