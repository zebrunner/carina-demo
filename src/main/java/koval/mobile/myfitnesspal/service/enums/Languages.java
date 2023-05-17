package koval.mobile.myfitnesspal.service.enums;

public enum Languages {
    ENGLISH("en_US"),
    SPANISH("es_ES");

    public final String language;

    Languages(String language) {
        this.language = language;
    }

    public String getShortLanguage() {
        return language;
    }

    public static Languages getLanguage(String shortLanguage) {
        for (Languages languages : Languages.values()) {
            if (languages.getShortLanguage().equals(shortLanguage)) {
                return languages;
            }
        }
        return null;
    }

}
