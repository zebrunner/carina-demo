package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.report.ReportContext;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.TutorialsModel;
import gherkin.deps.net.iharder.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ZafiraDashboardsPage extends AbstractPage {

    public ZafiraDashboardsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='logo-icon']")
    private ExtendedWebElement logoIcon;

    @FindBy(xpath = "//md-dialog[contains(@class,'zeb-tutorials-modal')]")
    private TutorialsModel tutorialsWindow;


    public boolean isOpened() {
        return isPageOpened() && logoIcon.isElementPresent();
    }

    public TutorialsModel getTutorialsWindow() {
        return tutorialsWindow;
    }

    public void createScreenshot() {
        Date date = new Date();
        BufferedImage im = Screenshot.captureFullSize(getDriver(), "screenshot".concat(date.toString()));
        File f = new File(String.format("%s/%s.png", ReportContext.getArtifactsFolder(), date.toString()));
        try {
            ImageIO.write(im, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
