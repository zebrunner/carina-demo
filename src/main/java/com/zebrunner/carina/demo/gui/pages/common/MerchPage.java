package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
public class MerchPage extends AbstractPage {
    public MerchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"fw-section-featured-collection-0\"]/section/div/div[2]/div/div/div/div[6]")
    private ExtendedWebElement productTile;

    @FindBy(xpath = "")
    private ExtendedWebElement selectColor;

    @FindBy(xpath = "//*[@id=\"fw-section-product\"]/section/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[2]/div")
    private ExtendedWebElement selectSize;

    @FindBy(xpath = "//*[@id=\"fw-section-product\"]/section/div/div[2]/div/div[2]/div/div/div[4]/div/div[1]/div[1]/select")
    private ExtendedWebElement selectQuantity;

    @FindBy(xpath = "//*[@id=\"fw-section-product\"]/section/div/div[2]/div/div[2]/div/div/div[4]/div/div[2]/button")
    private ExtendedWebElement addToChartButton;

    @FindBy(xpath = "//*[@id=\"fw-section-product\"]/aside/div[2]/div/div/div[4]/div/div[2]/form/button")
    private ExtendedWebElement viewCartButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/aside/div[2]/div/div/div[1]/div/div[2]/h4")
    private ExtendedWebElement itemsInChart;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div[2]/aside/div[1]/div/div/div/div[3]")
    private ExtendedWebElement chartQuantity;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div/div/div[2]/aside/div[1]/footer/div[3]/div[2]/div")
    private ExtendedWebElement totalChartPrise;

    public MerchPage setColor(String color) {
        selectColor.type(color);
        return this;
    }

    public MerchPage setSize(String size) {
        //selectSize.select(size);
        selectSize.click();
        return this;
    }

    public MerchPage setQuantity(int qty) {
        selectQuantity.click();
        selectQuantity.type(String.valueOf(qty));
        return this;
    }

    public MerchPage clickAddToChart() {
        addToChartButton.click();
        return this;
    }

    public MerchPage clickCheckoutBtn() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        viewCartButton.click();
        return this;
    }

    public void searchProduct(String request, String color, String size, int qty) {
        productTile.click();
        //how find requested item?
        //setColor(color);
        setSize(size);
        //setQuantity(qty); //how to set qty?
        clickAddToChart();
    }

    public String itemAddToChartVerify() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return itemsInChart.getText();
    }

    public String checkChartQuantity() {
        return chartQuantity.getText();
    }

    public String checkTotalPrise() {
        return totalChartPrise.getText();
    }


}
