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
package com.zebrunner.carina.demo.gui.pages.android;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.demo.gui.components.NewsItem;
import com.zebrunner.carina.demo.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.webdriver.locator.Context;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {

    @FindBy(xpath = "//div[@class='search-field']")
    private ExtendedWebElement searchComp;

    @Context(dependsOn = "searchComp")
    @FindBy(tagName = "input")
    private ExtendedWebElement searchField;

    @Context(dependsOn = "searchComp")
    @FindBy(tagName = "button")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='news-item']")
    private List<NewsItem> news;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchField);
    }

    @Override
    public List<NewsItem> searchNews(String searchInput) {
        searchField.type(searchInput);
        searchButton.click();

        return news;
    }

}
