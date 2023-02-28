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
package com.qaprosoft.carina.demo.gui.pages.desktop;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.footer.FooterMenu;
import com.qaprosoft.carina.demo.gui.pages.common.AllBrandsPageBase;
import com.qaprosoft.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.qaprosoft.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.qaprosoft.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBys({ @FindBy(xpath = "//p[contains(@class, 'pad')]"), @FindBy(xpath = ".//*[contains(@class, 'pad-single')]") })
    private ExtendedWebElement phoneFinderButton;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(xpath = "//span[text()='All brands']//parent::a")
    private ExtendedWebElement allBrandsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    @Override
    public CompareModelsPageBase openComparePage() {
        return getFooterMenu().openComparePage();
    }

    @Override
    public BrandModelsPageBase selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return initPage(driver, BrandModelsPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }

    public ExtendedWebElement getPhoneFinderButton() {
        return phoneFinderButton;
    }

    public AllBrandsPageBase openAllBrandsPage(){
        allBrandsButton.click();
        return initPage(driver, AllBrandsPageBase.class);
    }
}
