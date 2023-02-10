package koval.myfit.mobile.gui.android.menu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.menu.PlusButtonModalBase;
import koval.myfit.mobile.service.enums.BlocksTitles;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = PlusButtonModalBase.class)
public class PlusButtonModal extends PlusButtonModalBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.google.android.apps.fitness:id/add_entry_speed_dial")
    private ExtendedWebElement plusButtonMenuContainer;

    @FindBy(id = "com.google.android.apps.fitness:id/add_entry_fab")
    private ExtendedWebElement plusButton;

    @FindBy(id = "com.google.android.apps.fitness:id/cards_frame")
    private ExtendedWebElement mainBlockContainer;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.fitness:id/mtrl_internal_speed_dial_item_label")
    private List<ExtendedWebElement> listOfPlusButtonElement;

    public PlusButtonModal(WebDriver driver) {
        super(driver);
    }

    public PlusButtonModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public List<String> getPlusButtonMenuElementsToList() {

        if (listOfPlusButtonElement.isEmpty()) {
            Assert.fail("[HOME PAGE] List of Plus-Button Elements is empty!");
        }

        return listOfPlusButtonElement.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    @Override
    public boolean isPlusBtnStatic() {

        Point plusButtonLocation = plusButton.getLocation();
        Dimension plusButtonSize = plusButton.getSize();

        swipe(itemByText.format(BlocksTitles.TRENDS), IMobileUtils.Direction.UP);

        return plusButtonLocation.equals(plusButton.getLocation()) && plusButtonSize.equals(plusButton.getSize());
    }


    @Override
    public boolean isPlusBtnOverElements() {

        swipe(itemByText.format(BlocksTitles.DISCOVER), IMobileUtils.Direction.UP);
        plusButton.click();
        return plusButtonMenuContainer.isElementPresent(TIMEOUT_FIVE);

    }

    @Override
    public ExtendedWebElement openPlusButtonMenu() {

        plusButton.click();
        return plusButtonMenuContainer;

    }

    @Override
    public HomePageBase closePlusButtonMenu() {

        plusButton.click();
        return initPage(getDriver(), HomePageBase.class);

    }

    @Override
    public boolean isPlusButtonBelowBlockContainer() {

        swipe(itemByText.format("Learn more"), IMobileUtils.Direction.UP);
        swipeUp(MEDIUM_SPEED);
        return mainBlockContainer.getSize().height > plusButton.getSize().height;

    }

}
