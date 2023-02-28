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
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Path;

public class AttachFilePage extends AbstractPage {

    @FindBy(id = "file-upload")
    private ExtendedWebElement fileUploadingArea;

    @FindBy(id = "file-submit")
    private ExtendedWebElement submitButton;

    @FindBy(id = "content")
    private ExtendedWebElement content;

    public AttachFilePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(fileUploadingArea);
        setPageAbsoluteURL("https://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(Path pathToFile) {
        this.fileUploadingArea.attachFile(pathToFile.toAbsolutePath().toString());
    }

    public void submit() {
        this.submitButton.click();
    }

    public boolean isFileUploaded() {
        return this.content.isElementWithTextPresent("File Uploaded!");
    }
}
