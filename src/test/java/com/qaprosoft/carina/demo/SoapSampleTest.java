package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.soap.AddInteger;
import com.qaprosoft.carina.demo.soap.LookupCity;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoapSampleTest implements IAbstractTest {

    @Test
    public void testLookupCity() {
        LookupCity soap = new LookupCity();
        soap.setProperties("api/soap/soap.properties");
        soap.setHeaders(String.format("Content-type=%s", "text/xml"));
        soap.setHeaders(String.format("SOAPAction=%s", "http://tempuri.org/SOAP.Demo.LookupCity"));

        Response response = soap.callAPI();
        XmlPath rsBody = XmlPath.given(response.asString());
        String actualCity = rsBody.getString("City");
        String expectedCity = soap.getProperties().getProperty("city");

        soap.expectResponseStatus(HttpResponseStatusType.OK_200);
        Assert.assertTrue(actualCity.contains(expectedCity));
    }

    @Test
    public void testAddInteger() {
        AddInteger soap = new AddInteger();
        soap.setProperties("api/soap/soap.properties");
        soap.setHeaders(String.format("Content-type=%s", "text/xml"));
        soap.setHeaders(String.format("SOAPAction=%s", "http://tempuri.org/SOAP.Demo.AddInteger"));

        Response response = soap.callAPI();
        XmlPath rsBody = XmlPath.given(response.asString());
        Integer actualResult = rsBody.getInt("AddIntegerResult");
        Integer expectedResult = Integer.valueOf(soap.getProperties().getProperty("result"));

        soap.expectResponseStatus(HttpResponseStatusType.OK_200);
        Assert.assertEquals(actualResult, expectedResult);
    }
}