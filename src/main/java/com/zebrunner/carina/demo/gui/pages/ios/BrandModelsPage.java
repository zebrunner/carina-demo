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
package com.zebrunner.carina.demo.gui.pages.ios;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.demo.gui.components.ModelItem;
import com.zebrunner.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BrandModelsPageBase.class)
public class BrandModelsPage extends BrandModelsPageBase {

    @FindBy(xpath = "//div[@class='general-menu']//li")
    private List<ModelItem> models;

    @FindBy(xpath = "//div[@class='cls-btn']")
    private ExtendedWebElement adCloseButton;

    public BrandModelsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ModelInfoPageBase selectModel(String modelName) {
        adCloseButton.clickIfPresent();
        for (ModelItem model : models) {
            if (modelName.equalsIgnoreCase(model.readModel())) {
                return model.openModelPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);

    }

    @Override
    public List<ModelItem> getModels() {
        return models;
    }

}
