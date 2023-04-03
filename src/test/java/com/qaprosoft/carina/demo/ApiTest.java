package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.example.GetProductsMethod;
import org.testng.annotations.Test;

public class ApiTest implements IAbstractTest {

    @Test
    public void testGetProducts(){
        GetProductsMethod getProductsMethod = new GetProductsMethod();
        getProductsMethod.callAPIExpectSuccess();
    }
}
