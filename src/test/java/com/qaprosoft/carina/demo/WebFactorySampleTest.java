package com.qaprosoft.carina.demo;

import org.testng.annotations.Factory;

public class WebFactorySampleTest {

    @Factory
    public Object[] factoryMethod() {
        return new Object[] { new WebSampleTest(), new WebSampleTest(), new WebSampleTest(), new WebSampleTest(), new APISampleTest(),
                new APISampleTest() };
    }
}
