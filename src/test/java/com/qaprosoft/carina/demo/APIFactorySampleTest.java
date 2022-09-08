package com.qaprosoft.carina.demo;

import org.testng.annotations.Factory;

public class APIFactorySampleTest {
    @Factory
    public Object[] factoryMethod() {
        return new Object[] { new APISampleTest(), new APISampleTest(), new APISampleTest(), new APISampleTest(), new APISampleTest(),
                new APISampleTest() };
    }
}
