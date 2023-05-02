package koval.mobile.myfitnesspal.gui;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import koval.mobile.myfitnesspal.utils.IConstantUtils;

public interface IMyInterface extends IConstantUtils, IMobileUtils, IAbstractTest {

    AdbService adbService = new AdbService();

    default void pressKey(int keyCodeValue) {
        getDevice(getDriver()).pressKey(keyCodeValue);
    }


    default PhoneHomePageBase goHome() {
        pressKey(HOME_PAGE);
        return initPage(getDriver(), PhoneHomePageBase.class);
    }
}
