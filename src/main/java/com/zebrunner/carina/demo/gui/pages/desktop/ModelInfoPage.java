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

import com.zebrunner.carina.demo.gui.pages.common.ModelInfoPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ModelInfoPageBase.class)
public class ModelInfoPage extends ModelInfoPageBase {

    @FindBy(css = ".help-display strong")
    private ExtendedWebElement displayInfoLabel;

    @FindBy(css = ".help-camera strong")
    private ExtendedWebElement cameraInfoLabel;

    @FindBy(css = ".help-expansion strong")
    private ExtendedWebElement displayRamLabel;

    @FindBy(css = ".help-battery strong")
    private ExtendedWebElement batteryInfoLabel;

    public ModelInfoPage(WebDriver driver) {
        super(driver);
    }

    public String readDisplay() {
        assertElementPresent(displayInfoLabel);
        return displayInfoLabel.getText();
    }

    public String readCamera() {
        assertElementPresent(cameraInfoLabel);
        return cameraInfoLabel.getText();
    }

    public String readRam() {
        assertElementPresent(displayRamLabel);
        return displayRamLabel.getText();
    }

    public String readBattery() {
        assertElementPresent(displayInfoLabel);
        return batteryInfoLabel.getText();
    }

}
