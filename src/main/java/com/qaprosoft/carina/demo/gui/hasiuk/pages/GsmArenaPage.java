package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.hasiuk.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GsmArenaPage extends AbstractPage {

    @FindBy(id = "header")
    private Header header;

    public GsmArenaPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }
}
