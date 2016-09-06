package com.qaprosoft.carina.core.demo.gui.gsmarena.pages;

import com.qaprosoft.carina.core.demo.gui.gsmarena.components.productinfopage.ReviewHeader;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductInfoPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'hreview')]")
    private ReviewHeader reviewHeader;

    public ProductInfoPage(WebDriver driver) {
        super(driver);
    }

    public ReviewHeader getReviewHeader() {
        return reviewHeader;
    }
}
