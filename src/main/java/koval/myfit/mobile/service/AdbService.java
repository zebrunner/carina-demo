package koval.myfit.mobile.service;

import com.zebrunner.carina.utils.android.AndroidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


import static com.zebrunner.carina.utils.common.CommonUtils.pause;
import static koval.myfit.mobile.service.interfaces.IConstantUtils.TIMEOUT_FIVE;

public class AdbService extends AndroidService {

    public enum AppPackage{
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
        String[] command = { "adb", "-s", getDevice(getDriver()).getUdid(), "shell", "pm", "clear", packageName.getPackageName() };
        getDevice(getDriver()).execute(command);
    }

    public void startApp(AppPackage packName) {
        LOGGER.info("Starting " + packName.toString());
        String cmd = String.format("shell monkey -p %s -c android.intent.category.LAUNCHER 1", packName.getPackageName());
        executor.executeAdbCommand(cmd);
        pause(TIMEOUT_FIVE);
    }


    public void setDarkMode(String yesNo) {
        LOGGER.info("Set Dark Mode: " + yesNo);

        String cmd = String.format("shell cmd uimode night %s", yesNo);
        executor.executeAdbCommand(cmd);
        pause(TIMEOUT_FIVE);
    }
}
