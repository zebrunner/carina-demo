package koval.mobile.myfitnesspal.service;

import com.zebrunner.carina.utils.android.AndroidService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


import static com.zebrunner.carina.utils.common.CommonUtils.pause;
import static koval.mobile.myfitnesspal.utils.IConstantUtils.*;


public class AdbService extends AndroidService {

    public enum AppPackage {
        MY_FITNESS_PAL("com.myfitnesspal.android"),
        GOOGLE_FIT("com.google.android.apps.fitness"),
        CARINA_DEMO("com.solvd.carinademoapplication");

        public final String appPackage;

        AppPackage(String appPackage) {
            this.appPackage = appPackage;
        }

        public String getPackageName() {
            return appPackage;
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final AndroidService executor = AndroidService.getInstance();

    public void clearAppCache(AppPackage packageName) {
        LOGGER.info("Clear ['{}'] cache via ADB", packageName);
        String[] command = {"adb", "-s", getDevice(getDriver()).getUdid(), "shell", "pm", "clear", packageName.getPackageName()};
        getDevice(getDriver()).execute(command);
    }

    public void startApp(AppPackage packName) {
        LOGGER.info("Starting " + packName.toString());
        String cmd = String.format("shell monkey -p %s -c android.intent.category.LAUNCHER 1", packName.getPackageName());
        executor.executeAdbCommand(cmd);
        pause(TIMEOUT_FIVE);
    }

    public void closeApp(AppPackage packageName) {
        LOGGER.info("Closing app ['{}'] via ADB", packageName);
        String cmd = String.format("shell am force-stop %s", packageName.getPackageName());
        executor.executeAdbCommand(cmd);
        pause(TIMEOUT_FIVE);
    }

    public void holdElementByCoordinates(int centerX, int centerY) {
        LOGGER.info("Hold element via ADB.(long press) Center y: ['{}'] Center y: ['{}']", centerX, centerY);
        String cmd = String.format("shell input touchscreen swipe %s %s %s %s 700", centerX, centerY, centerX, centerY);
        executor.executeAdbCommand(cmd);
        pause(TIMEOUT_FIVE);
    }

    public void swipeElementByCoordinates(int centerX, int centerY, int dX, int dY) {
        LOGGER.info("Swipe element via ADB.");
        String cmd = String.format("shell input touchscreen swipe %s %s %s %s 20000", centerX, centerY, dX, dY);
        executor.executeAdbCommand(cmd);
        pause(TIMEOUT_FIVE);
    }


    public String getDeviceDisplaySize() {
        LOGGER.info("Get device display size via ADB");
        String cmd = "shell wm size";
        String deviceDisplaySize = executor.executeAdbCommand(cmd);
        pause(TIMEOUT_FIVE);
        return deviceDisplaySize;
    }


    public int getScreenPhysicalDensity() {
        LOGGER.info("Get screen physical density via ADB");
        String cmd = "shell wm density";
        int physicalDensity = Integer.parseInt(executor.executeAdbCommand(cmd).replaceAll(NUMBERS_ONLY, EMPTY_FIELD));
        pause(TIMEOUT_FIVE);
        return physicalDensity;
    }


    public boolean isKeyBoardOpen() {
        LOGGER.info("Check if keyboard is open via ADB");
        String cmd = "shell dumpsys input_method | grep mInputShown";
        boolean isKeyBoardOpenValue = Boolean.parseBoolean(String.valueOf(executor.executeAdbCommand(cmd).contains("true")));
        LOGGER.info("KeyBoard is open: {}", isKeyBoardOpenValue);
        pause(TIMEOUT_FIVE);
        return isKeyBoardOpenValue;
    }


    public void setDarkMode(String yesNo) {
        LOGGER.info("Set Dark Mode: " + yesNo);
        String cmd = String.format("shell cmd uimode night %s", yesNo);
        executor.executeAdbCommand(cmd);
        pause(TIMEOUT_FIVE);
    }
}
