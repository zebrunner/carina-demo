package koval.myfit.mobile.gui.pages;

public class My {

    public void runShellCommand() throws Exception {
        Process process = Runtime.getRuntime().exec("adb shell monkey -p com.google.android.apps.fitness -c android.intent.category.LAUNCHER 1");
        process.waitFor();
    }
}
