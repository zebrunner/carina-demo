package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='article-tags clearfix']")
    private ExtendedWebElement articleTag;

    @FindBy(xpath = "//*[@class='article-info-name']")
    private ExtendedWebElement articleTitle;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String articleTitle(){
        return articleTitle.getText();
    }

    public boolean isArticlePresented() {
        return articleTag.isPresent();
    }
}
