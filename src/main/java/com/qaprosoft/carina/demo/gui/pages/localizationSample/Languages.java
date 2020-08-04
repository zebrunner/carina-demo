package com.qaprosoft.carina.demo.gui.pages.localizationSample;

public enum Languages {
    EN("English"),
    ES("Español"),
    PT("Português"),
    FR("Français");

    private String text;

    Languages (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
