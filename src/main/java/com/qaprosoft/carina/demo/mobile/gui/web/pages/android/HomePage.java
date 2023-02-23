package com.qaprosoft.carina.demo.mobile.gui.web.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.BrandModelsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.CompareModelsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.NewsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//div[contains(@class, 'general-menu material-card')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(id = "news-container")
    private ExtendedWebElement newsColumn;

    @FindBy(xpath = "//span[@class='menu']")
    private ExtendedWebElement headerMenuButton;

    @FindBy(xpath = "//a[text()='Compare']")
    private ExtendedWebElement compareButton;

    @FindBy(xpath = "//header//nav//ul//a[text()='News']")
    private ExtendedWebElement newsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(newsColumn);
    }

    @Override
    public BrandModelsPageBase selectBrand(String brandName) {
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            if (brandName.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return initPage(driver, BrandModelsPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brandName);
    }

    @Override
    public CompareModelsPageBase openComparePage() {
        headerMenuButton.click();
        compareButton.click();
        return initPage(driver, CompareModelsPageBase.class);
    }

    @Override
    public NewsPageBase openNewsPage() {
        newsButton.click();
        return initPage(driver, NewsPageBase.class);
    }
}
