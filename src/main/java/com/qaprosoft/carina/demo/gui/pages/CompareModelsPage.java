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
package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.retry.ActionPoller;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.compare.CondidateBlock;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CompareModelsPage extends AbstractPage {

    private final String comparePageUrl = "https://www.gsmarena.com/compare.php3";

    @FindBy(xpath = "//div[contains(@class, 'candidate-search')]")
    private List<CondidateBlock> condidateBlocks;

    @FindBy(className = "compare-candidates")
    private ExtendedWebElement compareMenu;

    @FindBy(xpath = "//tr[.//a[text()='%s']]//td[@class='nfo'][%d]")
    private ExtendedWebElement specifications;

    public CompareModelsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(compareMenu);
        setPageAbsoluteURL(comparePageUrl);
        //setPageURL("/compare.php3");
    }

    public List<ModelSpecs> compareModels(String... models) {
        CondidateBlock condidateBlock;
        List<ModelSpecs> modelSpecs = new ArrayList<>();
        ModelSpecs modelSpec;
        ActionPoller<Boolean> actionPoller = ActionPoller.builder();
        actionPoller.task(() -> condidateBlocks.isEmpty())
                .until(isEmpty -> !isEmpty)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(15, ChronoUnit.SECONDS)
                .execute();

        for (int index = 0; index < models.length; index++) {
            modelSpec = new ModelSpecs();
            condidateBlock = condidateBlocks.get(index);
            condidateBlock.sendKeysToInputField(models[index]);
            condidateBlock.getFirstPhone();
            for (ModelSpecs.SpecType type : ModelSpecs.SpecType.values()) {
                ExtendedWebElement spec = specifications.format(type.getType(), index + 1);
                modelSpec.setToModelSpecsMap(type, spec.getText());
            }
            modelSpecs.add(modelSpec);
        }
        return modelSpecs;
    }
}
