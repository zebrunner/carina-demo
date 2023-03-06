package koval.myfit.mobile.utils;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import static koval.myfit.mobile.service.interfaces.IConstantUtils.*;


public class ColorUtils extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    Map<Integer, String> names = new HashMap<>();
    String colorResult;

    public ColorUtils(WebDriver driver) {
        super(driver);
    }


    public String getColorByName(ExtendedWebElement extendedWebElement) throws IOException {

        int max = getColorByNumber(extendedWebElement);

        if (!colorResult.equals(WHITE_COLOR)) {
            colorResult = names.get(max);
        }

        return colorResult;
    }


    public int getColorByNumber(ExtendedWebElement extendedWebElement) throws IOException {

        Point upperLeft = extendedWebElement.getLocation();
        Dimension dimensions = extendedWebElement.getSize();

        int red = 0;
        int green = 0;
        int blue = 0;
        colorResult = EMPTY_FIELD;

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(scrFile);

        for (int y = upperLeft.getY(); y < upperLeft.getY() + dimensions.getHeight(); y++) {
            for (int x = upperLeft.getX(); x < upperLeft.getX() + dimensions.getWidth(); x++) {
                int clr = image.getRGB(x, y);

                red = red + ((clr & 0x00ff0000) >> 16);
                green = green + ((clr & 0x0000ff00) >> 8);
                blue = blue + (clr & 0x000000ff);
            }
        }

        names.put(red, RED_COLOR);
        names.put(green, GREEN_COLOR);
        names.put(blue, BLUE_COLOR);

        if (Math.abs(red - green ) < 5 && Math.abs(green - blue) < 5) {
            colorResult = WHITE_COLOR;
        }

        return Math.max(red, Math.max(green, blue));
    }


    public String getCenterColorByName(ExtendedWebElement extendedWebElement) throws IOException {

        int max = getCenterColorByNumber(extendedWebElement);

        if (!colorResult.equals(WHITE_COLOR)) {
            colorResult = names.get(max);
        }

        return colorResult;
    }

    public int getCenterColorByNumber(ExtendedWebElement extendedWebElement) throws IOException {

        int red = 0;
        int green = 0;
        int blue = 0;
        colorResult = EMPTY_FIELD;

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(scrFile);

        int x = getCenterX(extendedWebElement);
        int y = getCenterY(extendedWebElement);
        int clr = image.getRGB(x - 1, y);

        red = red + ((clr & 0x00ff0000) >> 16);
        green = green + ((clr & 0x0000ff00) >> 8);
        blue = blue + (clr & 0x000000ff);

        names.put(red, RED_COLOR);
        names.put(green, GREEN_COLOR);
        names.put(blue, BLUE_COLOR);


        if (Math.abs(red - green ) < 5 && Math.abs(green - blue) < 5) {
            colorResult = WHITE_COLOR;
        }

        return Math.max(red, Math.max(green, blue));
    }


    public int getCenterX(ExtendedWebElement extendedWebElement) {

        int leftX = extendedWebElement.getLocation().getX();
        int rightX = extendedWebElement.getSize().getWidth();

        return (leftX + (leftX + rightX)) / 2;
    }

    public int getCenterY(ExtendedWebElement extendedWebElement) {

        int upperY = extendedWebElement.getLocation().getY();
        int lowerY = extendedWebElement.getSize().getHeight();

        return (upperY + (upperY + lowerY)) / 2;
    }

}
