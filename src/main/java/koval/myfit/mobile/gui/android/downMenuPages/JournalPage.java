package koval.myfit.mobile.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.android.modal.DownMenuModal;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/collapsing_toolbar")
    private ExtendedWebElement title;

    @FindBy(id = "com.google.android.apps.fitness:id/bottom_navigation")
    private DownMenuModal downMenuModal;

    @FindBy(xpath = "//*[contains(@resource-id, 'journal_recycler_view')]/child::*[@class='android.view.ViewGroup']")
    private List<ExtendedWebElement> activityList;


    @FindBy(id = "com.google.android.apps.fitness:id/session_duration")
    private ExtendedWebElement durationLabel;


    @FindBy(id = "com.google.android.apps.fitness:id/session_start_time")
    private ExtendedWebElement startTimeLabel;

    @FindBy(id = "com.google.android.apps.fitness:id/header_title")
    private ExtendedWebElement startDateLabel;


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public JournalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return title.isElementPresent(TIMEOUT_FIVE) && title.getAttribute("content-desc").equals("Journal");
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        return downMenuModal.openPageByName(downMenuElement);
    }

    @Override
    public String getActivityName() {

        return activityList.get(0).findExtendedWebElement(By.id("com.google.android.apps.fitness:id/session_title")).getText();
    }

    @Override
    public boolean isActivityPresent(String activityTitle) {


        boolean isActivityPresent = false;
        for (ExtendedWebElement extendedWebElement : activityList) {
            isActivityPresent = extendedWebElement.findExtendedWebElement(By.id("com.google.android.apps.fitness:id/session_title")).getText().contains(activityTitle.toLowerCase());
        }


        return isActivityPresent;

    }

    @Override
    public ActivityPageBase openActivity() {

        if (!activityList.isEmpty()) {

            activityList.get(0).findExtendedWebElement(By.id("com.google.android.apps.fitness:id/session_title")).click();


        }

        return initPage(getDriver(), ActivityPageBase.class);
    }

    @Override
    public int getActivityListSize() {

        return activityList.size();
    }

}
