package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class DragAndDropPage extends AbstractPage implements IMobileUtils {

    @FindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private ExtendedWebElement target;

    @FindBy(id = "io.appium.android.apis:id/drag_dot_2")
    private ExtendedWebElement rightDestination;

    @FindBy(id = "io.appium.android.apis:id/drag_dot_3")
    private ExtendedWebElement downDestination;

    @FindBy(id = "io.appium.android.apis:id/drag_dot_hidden")
    private ExtendedWebElement diagonalDestination;

    @FindBy(id = "io.appium.android.apis:id/drag_text")
    private ExtendedWebElement dragAndDropMessage;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragRight() {
        dragAndDrop(target, rightDestination,Duration.ofSeconds(2),Duration.ofSeconds(3));
    }

    public void dragDown() {
        dragAndDrop(target, downDestination,Duration.ofSeconds(2),Duration.ofSeconds(3));
    }

    public void dragDiagonal() {
        dragAndDrop(target, diagonalDestination,Duration.ofSeconds(2),Duration.ofSeconds(3));
    }

    public boolean isDragAndDropMessagePresent(){
        return !dragAndDropMessage.getText().isBlank();
    }
}