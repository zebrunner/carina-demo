package com.qaprosoft.carina.demo.mobile.gui.web.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.NewsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {
    @FindBy(xpath = "//div[@class='search-field']//input[@type='search']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//div[@class='search-field']//button")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='news-item']//h2")
    private List<ExtendedWebElement> news;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchField);
    }

    @Override
    public List<String> searchNews(String searchInput) {
        searchField.type(searchInput);
        searchButton.click();

        ArrayList<String> newsText = new ArrayList<>();
        for (int i = 0; i < news.size(); i++) {
            newsText.add(news.get(i).getText());
        }
        return newsText;
    }
}
