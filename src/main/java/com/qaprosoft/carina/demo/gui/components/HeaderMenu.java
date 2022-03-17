/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
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
 */
package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(xpath = "//div[contains(@class, 'top-bar ')]/button")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//div[@id='logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//div[@id='nav']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//div[@id='social-connect']/a")
    private List<ExtendedWebElement> headerLinks;

    @FindBy(xpath = "//ul[@id='menu']/li")
    private List<ExtendedWebElement> menuItems;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getMenuButton() {
        return menuButton;
    }

    public ExtendedWebElement getLogo() {
        return logo;
    }

    public ExtendedWebElement getSearchField() {
        return searchField;
    }

    public List<ExtendedWebElement> getHeaderLinks() {
        return headerLinks;
    }

    public List<ExtendedWebElement> getMenuItems() {
        return menuItems;
    }
}
