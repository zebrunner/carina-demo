package com.qaprosoft.carina.demo.ui.components;

public enum NavigationUrl {
    OVERVIEW("http://zebrunner.github.io/carina/"),
    GETTING_STARTED("http://zebrunner.github.io/carina/getting_started/"),
    PROJECT_STRUCTURE("http://zebrunner.github.io/carina/project_structure/"),
    CONFIGURATION("http://zebrunner.github.io/carina/configuration/"),
    EXECUTION("http://zebrunner.github.io/carina/execution/"),
    WEB("http://zebrunner.github.io/carina/automation/web/"),
    MOBILE_IN_AUTOMATION("http://zebrunner.github.io/carina/automation/mobile/"),
    API("http://zebrunner.github.io/carina/automation/api/"),
    WINDOWS("http://zebrunner.github.io/carina/automation/windows/"),
    DATABASE("http://zebrunner.github.io/carina/advanced/database/"),
    DATAPROVIDER("http://zebrunner.github.io/carina/advanced/dataprovider/"),
    DRIVER("http://zebrunner.github.io/carina/advanced/driver/"),
    MOBILE_IN_ADVANCED("http://zebrunner.github.io/carina/advanced/mobile/"),
    LOCALIZATION("http://zebrunner.github.io/carina/advanced/localization/"),
    PROGRAM_FLOW("http://zebrunner.github.io/carina/advanced/program_flow/"),
    PROXY("http://zebrunner.github.io/carina/advanced/proxy/"),
    SCREENSHOT("http://zebrunner.github.io/carina/advanced/screenshot/"),
    SECURITY("http://zebrunner.github.io/carina/advanced/security/"),
    ZEBRUNNER("http://zebrunner.github.io/carina/integration/zebrunner/"),
    CUCUMBER("http://zebrunner.github.io/carina/cucumber/"),
    CONTRIBUTION("http://zebrunner.github.io/carina/contribution/");

    private final String url;

    NavigationUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
