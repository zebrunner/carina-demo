package com.qaprosoft.carina.demo;


import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

public class HelloWorld implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void helloWorld() {

    }
}