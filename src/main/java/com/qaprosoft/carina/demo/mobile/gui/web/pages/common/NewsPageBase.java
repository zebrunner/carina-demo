package com.qaprosoft.carina.demo.mobile.gui.web.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class NewsPageBase extends AbstractPage {
    public NewsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> searchNews(String searchInput);
}
