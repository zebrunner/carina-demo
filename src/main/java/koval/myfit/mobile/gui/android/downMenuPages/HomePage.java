package koval.myfit.mobile.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.android.modal.DownMenuModal;
import koval.myfit.mobile.gui.android.modal.PlusButtonModal;
import koval.myfit.mobile.gui.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.modal.PlusButtonModalBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.MaterialCardTopics;
import koval.myfit.mobile.service.enums.PlusButtonMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.stream.Collectors;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "om.google.android.apps.fitness:id/add_entry_fab")
    private PlusButtonModal plusButtonModal;

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

    @FindBy(xpath = "//*[contains(@resource-id, 'material_card')]/child::*//*[@text='%s']")
    private ExtendedWebElement materialCardBlock;


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
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        return downMenuModal.openPageByName(downMenuElement);
    }


    @Override
    public boolean isPlusBtnStatic() {
        return plusButtonModal.isPlusBtnStatic();
    }


    @Override
    public boolean isPlusBtnOverElements() {
        return plusButtonModal.isPlusBtnOverElements();
    }

    @Override
    public AbstractPage openPageFromPlusButtonMenuByName(PlusButtonMenuElement plusButtonMenuElement) {

        return plusButtonModal.openPageByName(plusButtonMenuElement);
    }

    @Override
    public HomePageBase closePlusButtonMenu() {

        return plusButtonModal.closePlusButtonMenu();
    }

    @Override
    public PlusButtonModalBase openPlusButtonMenu() {

        return plusButtonModal.openPlusButtonMenu();
    }

    @Override
    public boolean isPlusButtonBelowBlockContainer() {
        return plusButtonModal.isPlusButtonBelowBlockContainer();
    }


    @Override
    public boolean isBlockByTitlePresent(MaterialCardTopics topic) {

        swipe(materialCardBlock.format(topic.getTopicName()));

        return materialCardBlock.format(topic.getTopicName()).isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public List<String> getPlaylistTitlesToList() {

        List<String> playlistTitlesList = new ArrayList<>();
        int expectedSizeOfListElements = 6;

        while (playlistTitlesList.size() != expectedSizeOfListElements) {

            playlistTitlesList.addAll(listOfPlaylistTitles.stream().map(ExtendedWebElement::getText).
                    collect(Collectors.toList()));

            while (itemByText.format(playlistTitlesList.get(playlistTitlesList.size() - 1)).isElementPresent(TIMEOUT_FIVE)
                    && !itemByText.format("Sleep").isElementPresent(TIMEOUT_FIVE)) {

                swipeLeft(playlistCarouselContainer, HIGH_SPEED);
            }
        }
        return playlistTitlesList;
    }

}
