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
package com.zebrunner.carina.demo.gui.components.compare;

import java.util.HashMap;
import java.util.Map;

public class ModelSpecs {

    public enum SpecType {
        TECHNOLOGY("Technology"),
        ANNOUNCED("Announced");

        private final String type;

        SpecType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private final Map<SpecType, String> modelSpecsMap;

    public ModelSpecs() {
        this.modelSpecsMap = new HashMap<>();
    }

    public void setToModelSpecsMap(SpecType specType, String spec) {
        this.modelSpecsMap.put(specType, spec);
    }

    public String readSpec(SpecType specType) {
        return modelSpecsMap.get(specType);
    }
}
