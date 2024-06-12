package com.qaprosoft.carina.demo.beatsbydre;

import org.testng.annotations.BeforeMethod;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;

public class AbstractBeatsByDreTest implements IAbstractTest {
    private static final String SITE_URL = "https://www.beatsbydre.com/";

    @BeforeMethod
    public void configure(){
        String country = L10N.getLocale().getCountry().toLowerCase();
        if (country.equals("us")) {
            country = "";
        }
        R.CONFIG.put(Configuration.Parameter.URL.getKey(), SITE_URL + country, true);
    }
}
