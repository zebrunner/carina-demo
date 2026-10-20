package com.zebrunner.carina.demo.gui.pages.desktop;

import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Path;

public class WebFormPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(@class,'display-6')]")
    private ExtendedWebElement heading;

    @FindBy(id = "my-text-id")
    private ExtendedWebElement textInput;

    @FindBy(name = "my-password")
    private ExtendedWebElement passwordInput;

    @FindBy(name = "my-textarea")
    private ExtendedWebElement textarea;

    @FindBy(name = "my-disabled")
    private ExtendedWebElement disabledInput;

    @FindBy(name = "my-readonly")
    private ExtendedWebElement readonlyInput;

    @FindBy(name = "my-select")
    private ExtendedWebElement dropdown;

    @FindBy(name = "my-datalist")
    private ExtendedWebElement datalistInput;

    @FindBy(name = "my-file")
    private ExtendedWebElement fileInput;

    @FindBy(id = "my-check-1")
    private ExtendedWebElement firstCheckbox;

    @FindBy(id = "my-check-2")
    private ExtendedWebElement secondCheckbox;

    @FindBy(id = "my-radio-1")
    private ExtendedWebElement firstRadio;

    @FindBy(id = "my-radio-2")
    private ExtendedWebElement secondRadio;

    @FindBy(name = "my-colors")
    private ExtendedWebElement colorPicker;

    @FindBy(name = "my-date")
    private ExtendedWebElement datePicker;

    @FindBy(name = "my-range")
    private ExtendedWebElement range;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement submitButton;

    public WebFormPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(heading);
        setPageAbsoluteURL("https://www.selenium.dev/selenium/web/web-form.html");
    }

    public ExtendedWebElement getHeading() {
        return heading;
    }

    public void typeText(String text) {
        textInput.type(text);
    }

    public String getText() {
        return textInput.getAttribute("value");
    }

    public void pasteIntoText() {
        textInput.getElement().clear();
        textInput.click();
        textInput.getElement().sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }

    public void copyText() {
        textInput.click();
        textInput.getElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        textInput.getElement().sendKeys(Keys.chord(Keys.CONTROL, "c"));
    }

    public void setLocalStorageValue(String name, String value) {
        ((JavascriptExecutor) getDriver()).executeScript("window.localStorage.setItem(arguments[0], arguments[1]);", name, value);
    }

    public void reload() {
        getDriver().navigate().refresh();
    }

    public void typePassword(String password) {
        passwordInput.type(password);
    }

    public String getPassword() {
        return passwordInput.getAttribute("value");
    }

    public void typeTextarea(String text) {
        textarea.type(text);
    }

    public String getTextarea() {
        return textarea.getAttribute("value");
    }

    public boolean isDisabledInputEnabled() {
        return disabledInput.getElement().isEnabled();
    }

    public String getReadonlyValue() {
        return readonlyInput.getAttribute("value");
    }

    public void selectDropdown(String option) {
        dropdown.select(option);
    }

    public String getSelectedDropdown() {
        return dropdown.getSelectedValue();
    }

    public void typeDatalist(String text) {
        datalistInput.type(text);
    }

    public String getDatalist() {
        return datalistInput.getAttribute("value");
    }

    public void attachFile(Path file) {
        fileInput.attachFile(file.toAbsolutePath().toString());
    }

    public String getAttachedFileName() {
        return fileInput.getAttribute("value");
    }

    public void setFirstCheckbox(boolean checked) {
        setChecked(firstCheckbox, checked);
    }

    public boolean isFirstCheckboxChecked() {
        return firstCheckbox.isChecked();
    }

    public void setSecondCheckbox(boolean checked) {
        setChecked(secondCheckbox, checked);
    }

    public boolean isSecondCheckboxChecked() {
        return secondCheckbox.isChecked();
    }

    public void selectFirstRadio() {
        firstRadio.click();
    }

    public boolean isFirstRadioSelected() {
        return firstRadio.isChecked();
    }

    public void selectSecondRadio() {
        secondRadio.click();
    }

    public boolean isSecondRadioSelected() {
        return secondRadio.isChecked();
    }

    public void setColor(String hexColor) {
        setValue(colorPicker, hexColor);
    }

    public String getColor() {
        return colorPicker.getAttribute("value");
    }

    public void typeDate(String date) {
        datePicker.type(date);
        heading.click();
    }

    public String getDate() {
        return datePicker.getAttribute("value");
    }

    public void setRange(int value) {
        range.getElement().sendKeys(Keys.HOME);
        for (int i = 0; i < value; i++) {
            range.getElement().sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getRange() {
        return range.getAttribute("value");
    }

    public WebFormSubmittedPage submit() {
        submitButton.scrollTo();
        submitButton.click();
        return new WebFormSubmittedPage(getDriver());
    }

    public Object getTextThroughDevTools(ChromeDevToolsService devTools) {
        return devTools.getRuntime()
                .evaluate("document.getElementById('my-text-id').value")
                .getResult()
                .getValue();
    }

    private void setChecked(ExtendedWebElement element, boolean checked) {
        if (element.isChecked() != checked) {
            element.click();
        }
    }

    private void setValue(ExtendedWebElement element, String value) {
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].value = arguments[1];"
                        + "arguments[0].dispatchEvent(new Event('input', {bubbles: true}));"
                        + "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
                element.getElement(), value);
    }
}
