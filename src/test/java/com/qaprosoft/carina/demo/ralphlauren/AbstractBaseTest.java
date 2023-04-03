package com.qaprosoft.carina.demo.ralphlauren;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.BeforeSuite;

public class AbstractBaseTest implements IAbstractTest {
    public static final String RALPH_LAUREN_URL = "https://www.ralphlauren.com/";

    @BeforeSuite
    public void configureTestUrl() {
        R.CONFIG.put(Configuration.Parameter.URL.getKey(), RALPH_LAUREN_URL);
    }


}