package koval.myfit;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.myfit.mobile.gui.pages.Check;
import koval.myfit.mobile.gui.pages.My;
import koval.myfit.mobile.gui.pages.common.menuPages.HomePageBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class Testermy implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. Check if Home page is open", value = {"mobile"})
    public void test() throws Exception {

//        String commandToRun = "adb shell settings put secure location_providers_allowed gps, wifi,network a broadcast -a android.location.GPS_ENABLED_CHANGE --ez enabled true";
//        Runtime.getRuntime().exec(commandToRun);

        Process p = Runtime.getRuntime().exec(new String[]{"bash", "-l", "-c", "adb devices"});
        LOGGER.info(p.toString());

//    My my = new My();
//
//  my.runShellCommand();
    }

}
