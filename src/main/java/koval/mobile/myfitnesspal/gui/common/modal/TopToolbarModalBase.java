package koval.mobile.myfitnesspal.gui.common.modal;


import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public abstract class TopToolbarModalBase extends MyAbstractPage {


    public TopToolbarModalBase(WebDriver driver) {
        super(driver);
    }

    public TopToolbarModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }


    public abstract boolean isPageOpened(String textTitle);

    public abstract String getTitleText();

    public abstract WelcomePageBase clickReturnBackButton();
}
