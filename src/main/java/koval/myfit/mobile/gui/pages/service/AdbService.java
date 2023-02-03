package koval.myfit.mobile.gui.pages.service;

import java.io.IOException;


import static koval.myfit.mobile.gui.pages.service.interfaces.IConstantUtils.ADB_PATH;

public class AdbService {

    static public void openApp() throws IOException, InterruptedException {
        String cmd = ADB_PATH + " shell monkey -p com.google.android.apps.fitness -c android.intent.category.LAUNCHER 1";

        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
    }

    static public void clearCash() throws IOException, InterruptedException {
        String cmd = ADB_PATH + " shell pm clear com.google.android.apps.fitness";

        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
    }

}
