package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import java.time.Duration;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class DragAndDropPage extends AbstractPage implements IMobileUtils {

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private ExtendedWebElement target;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_2")
    private ExtendedWebElement rightDestination;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_3")
    private ExtendedWebElement downDestination;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_hidden")
    private ExtendedWebElement diagonalDestination;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_text")
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
