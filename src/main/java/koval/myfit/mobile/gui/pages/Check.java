package koval.myfit.mobile.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class Check implements IDriverPool, ICustomTypePageFactory {


    public void startApp(){
        String packageName = "com.google.android.apps.fitness";
        //String []cmd = {"adb", "shell", "monkey", "-p", "com.google.android.apps.fitness", "-c", "android.intent.category.LAUNCHER 1"};
        String[] cmd = {"adb", "-s", getDevice().getUdid(), "shell", };
        getDevice().execute(cmd);

    }



}
