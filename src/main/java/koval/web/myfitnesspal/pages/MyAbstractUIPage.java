package koval.web.myfitnesspal.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import koval.web.myfitnesspal.utils.IConstantUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MyAbstractUIPage extends AbstractUIObject implements IConstantUtils {

    public MyAbstractUIPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//*[text()='%s']")
    public ExtendedWebElement itemByText;


    public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

}
