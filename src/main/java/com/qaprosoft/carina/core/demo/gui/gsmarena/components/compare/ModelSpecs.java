package com.qaprosoft.carina.core.demo.gui.gsmarena.components.compare;

import java.util.Map;

public class ModelSpecs {

    public enum SpecType {

        TECHNOLOGY("Technology"),
        ANNOUNCED("Announced");

        private String type;

        SpecType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private Map<SpecType, String> modelSpecsMap;

    public void setToModelSpecsMap(SpecType specTypeName, String spec) {
        this.modelSpecsMap.put(specTypeName, spec);
    }
}
