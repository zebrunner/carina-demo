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
package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.pages.common.ModelInfoPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class ModelItem extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//strong")
    private ExtendedWebElement modelLabel;

    @FindBy(xpath = ".//a")
    private ExtendedWebElement modelLink;

    public ModelItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readModel() {
        return modelLabel.getText();
    }

    public ModelInfoPageBase openModelPage() {
        modelLink.click();
        return initPage(driver, ModelInfoPageBase.class);
    }
}
