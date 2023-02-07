package koval.myfit.mobile.gui.pages.android.menuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.pages.android.menu.DownMenuModal;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.pages.common.menuPages.HomePageBase;
import koval.myfit.mobile.gui.pages.service.enums.BlocksTitles;
import koval.myfit.mobile.gui.pages.service.enums.DownMenuElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.stream.Collectors;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.google.android.apps.fitness:id/add_entry_speed_dial")
    private ExtendedWebElement plusButtonMenuContainer;

    @FindBy(id = "com.google.android.apps.fitness:id/add_entry_fab")
    private ExtendedWebElement plusButton;

    @FindBy(id = "com.google.android.apps.fitness:id/cards_frame")
    private ExtendedWebElement container;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.fitness:id/playlist_carousel")
    private ExtendedWebElement playlistCarouselContainer;

    @FindBy(id = "com.google.android.apps.fitness:id/bottom_navigation")
    private DownMenuModal downMenuModal;

    @FindBy(id = "com.google.android.apps.fitness:id/halo_view")
    private ExtendedWebElement activityChartView;

    @FindBy(id = "com.google.android.apps.fitness:id/og_apd_internal_image_view")
    private ExtendedWebElement profileImage;

    @FindBy(id = "com.google.android.apps.fitness:id/og_text_card_title")
    private ExtendedWebElement signOutButton;

    @FindBy(id = "com.google.android.apps.fitness:id/title")
    private List<ExtendedWebElement> listOfPlaylistTitles;

    @FindBy(xpath = "//*[contains(@resource-id, 'material_card')]")
    private List<ExtendedWebElement> listOfMaterialCardBlock;

    @FindBy(id = "com.google.android.apps.fitness:id/mtrl_internal_speed_dial_item_label")
    private List<ExtendedWebElement> listOfPlusButtonElement;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return activityChartView.isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public WelcomePageBase signOut() {
        profileImage.click();
        signOutButton.click();
        return initPage(getDriver(), WelcomePageBase.class);
    }

    @Override
    public AbstractPage open(DownMenuElement downMenuElement) {
        return downMenuModal.openPageByName(downMenuElement);

    }

    @Override
    public List<String> getPlusButtonMenuElementsToList() {

        if (listOfPlusButtonElement.isEmpty()) {
            Assert.fail("[HOME PAGE] List of Plus-Button Elements is empty!");
        }

        return listOfPlusButtonElement.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }


    @Override
    public boolean isPlusButtonOverOtherElements() {

        plusButton.click();
        return plusButtonMenuContainer.isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public boolean isPlusBtnStatic() {

        int x = plusButton.getLocation().x;
        int y = plusButton.getLocation().y;
        int height = plusButton.getSize().height;
        int width = plusButton.getSize().width;

        while (!itemByText.format("Learn more").isElementPresent(TIMEOUT_FIVE)) {
            swipeUp(HIGH_SPEED);

            if (x != plusButton.getLocation().x && y != plusButton.getLocation().y &&
                    height != plusButton.getSize().height && width != plusButton.getSize().width) {
                return false;
            }

            Assert.assertTrue(isPlusButtonOverOtherElements(), "[ HOME PAGE ] Plus-Button is under other element!");
            plusButton.click();
        }
        return true;
    }

    @Override
    public int getContainerHeight() {
        return container.getSize().height;
    }

    @Override
    public List<String> getMaterialCardTopicsToList() {

        List<String> materialCardTopicsList = new ArrayList<>();
        int expectedSizeOfListElements = 10;
        int i = 0;
        String titleText = String.valueOf(BlocksTitles.TRENDS);

        while (materialCardTopicsList.size() != expectedSizeOfListElements) {

            swipe(itemByText.format(titleText), Direction.UP);

            Assert.assertTrue(listOfMaterialCardBlock.get(i).isElementPresent(TIMEOUT_FIVE),
                    String.format("[ HOME PAGE ] Block element from listOfMaterialCardBlock is not present, index '%s'", i));

            materialCardTopicsList.add(String.valueOf(listOfMaterialCardBlock.get(i).
                    findExtendedWebElement(By.id("com.google.android.apps.fitness:id/card_title")).getText()));

            i++;

            if (i == 3 && titleText.equals(String.valueOf(BlocksTitles.TRENDS))) {
                titleText = String.valueOf(BlocksTitles.DISCOVER);
                i--;
            }

            if (i == 5 && titleText.equals(String.valueOf(BlocksTitles.DISCOVER))) {
                titleText = "Your sleep in Fit";
                i = 1;
            }

            if (i == 2 && titleText.equals("Your sleep in Fit")) {
                materialCardTopicsList.add(String.valueOf(listOfMaterialCardBlock.get(i).findExtendedWebElement
                        (By.id("com.google.android.apps.fitness:id/card_title")).getAttribute("content-desc")));
                i++;
            }
        }

        return materialCardTopicsList;
    }

    @Override
    public List<String> getPlaylistTitlesToList() {

        List<String> playlistTitlesList = new ArrayList<>();
        int expectedSizeOfListElements = 6;
        String lastItemFromList;

        while (playlistTitlesList.size() != expectedSizeOfListElements) {

            playlistTitlesList.add(listOfPlaylistTitles.get(0).getText());

            if (playlistTitlesList.size() == expectedSizeOfListElements - 1) {
                playlistTitlesList.add(listOfPlaylistTitles.get(1).getText());
                break;
            }

            lastItemFromList = playlistTitlesList.get(playlistTitlesList.size() - 1);

            while (itemByText.format(lastItemFromList).isElementPresent(TIMEOUT_FIVE)) {

                lastItemFromList = playlistTitlesList.get(playlistTitlesList.size() - 1);
                swipeLeft(playlistCarouselContainer, HIGH_SPEED);
            }
        }

        return playlistTitlesList;
    }

}
