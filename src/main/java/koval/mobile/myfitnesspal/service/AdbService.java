package koval.mobile.myfitnesspal.service;

import com.zebrunner.carina.utils.android.AndroidService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


import static com.zebrunner.carina.utils.common.CommonUtils.pause;
import static koval.mobile.myfit.service.interfaces.IConstantUtils.TIMEOUT_FIVE;
import static koval.mobile.myfitnesspal.utils.IConstantUtils.*;


public class AdbService extends AndroidService {

    public enum AppPackage {
        MY_FITNESS_PAL("com.myfitnesspal.android", "MyFitnessPal.apk"),
        GOOGLE_FIT("com.google.android.apps.fitness", "Fit_base.apk"),
        CARINA_DEMO("com.solvd.carinademoapplication", "carinademoexample.apk");

        public final String appPackage;

        public final String apkName;

        AppPackage(String appPackage, String apkName) {
            this.appPackage = appPackage;
            this.apkName = apkName;
        }

        public String getPackageName() {
            return appPackage;
        }

        public String getApkName() {
            return apkName;
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final AndroidService executor = AndroidService.getInstance();

    public void clearAppCache(AppPackage packageName) {
        LOGGER.info("Clear ['{}'] cache via ADB", packageName);
        String[] command = {"adb", "-s", getDevice(getDriver()).getUdid(), "shell", "pm", "clear", packageName.getPackageName()};
        getDevice(getDriver()).execute(command);
    }



    public void installApp(AppPackage packName) {

        LOGGER.info("Installing " + packName);
        String cm = "install -r " + System.getProperty("user.dir") + "/apk/" + packName.getApkName();
        executor.executeAdbCommand(cm);
        pause(TIMEOUT_TWENTY);
    }
    public void startApp(AppPackage packName) {

        LOGGER.info("Starting " + packName);
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


}
