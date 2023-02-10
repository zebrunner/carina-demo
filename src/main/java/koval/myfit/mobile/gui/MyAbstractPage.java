package koval.myfit.mobile.gui;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MyAbstractPage extends AbstractPage implements IMyInterface{

    public MyAbstractPage(WebDriver driver) {
        super(driver);
    }

}
