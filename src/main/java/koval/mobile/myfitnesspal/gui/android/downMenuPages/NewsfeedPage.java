package koval.mobile.myfitnesspal.gui.android.downMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.NewsfeedPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsfeedPageBase.class)
public class NewsfeedPage extends NewsfeedPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;


    public NewsfeedPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }
}
