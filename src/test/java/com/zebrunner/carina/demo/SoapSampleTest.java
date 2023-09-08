package com.zebrunner.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.soap.AddIntegerMethod;
import com.zebrunner.carina.demo.soap.LookupCityMethod;
import com.zebrunner.carina.api.apitools.validation.XmlCompareMode;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class SoapSampleTest implements IAbstractTest {

    @Test
    public void testAddInteger() {
        AddIntegerMethod soap = new AddIntegerMethod();
        soap.setProperties("api/soap/soap.properties");

        Response response = soap.callAPIExpectSuccess();
        XmlPath rsBody = XmlPath.given(response.asString());
        Integer actualResult = rsBody.getInt("AddIntegerResult");
        Integer expectedResult = Integer.valueOf(soap.getProperties().getProperty("result"));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLookupCity() {
        LookupCityMethod soap = new LookupCityMethod();
        soap.setProperties("api/soap/soap.properties");

        soap.callAPIExpectSuccess();
        soap.validateXmlResponse(XmlCompareMode.STRICT);
    }

}
