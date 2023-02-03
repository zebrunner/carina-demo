package koval.myfit.mobile.gui.pages.android.menuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.pages.android.menu.DownMenuModal;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.pages.common.menuPages.HomePageBase;
import koval.myfit.mobile.gui.pages.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/bottom_navigation")
    private DownMenuModal downMenuModal;

    @FindBy(id = "com.google.android.apps.fitness:id/halo_view")
    private ExtendedWebElement activityChartView;

    @FindBy(id = "com.google.android.apps.fitness:id/og_apd_internal_image_view")
    private ExtendedWebElement profileImage;

    @FindBy(id = "com.google.android.apps.fitness:id/og_text_card_title")
    private ExtendedWebElement signOutButton;

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

}
