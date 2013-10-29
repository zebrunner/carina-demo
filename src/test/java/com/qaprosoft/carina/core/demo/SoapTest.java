package com.qaprosoft.carina.core.demo;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.eviware.soapui.tools.SoapUITestCaseRunner;
import com.qaprosoft.carina.core.foundation.APITest;

/**
 * Test that demonstrates integration with SoapUI.
 * 
 * @author akhursevich
 */
public class SoapTest extends APITest
{
	private static final String SOAP_PROJ_ROOT = "./soap/geoip";

	private Properties configProp;
	private Properties testdataProp;
	private Properties tempProp;

	@BeforeTest
	public void init() throws Exception
	{
		configProp = loadProp(SOAP_PROJ_ROOT + "/Config.properties");
		testdataProp = loadProp(SOAP_PROJ_ROOT + "/Testdata.properties");
	}

	@Test(dataProvider = "excel_ds")
	@Parameters({ "testTitle", "ip", "countryCode", "countryName" })
	public void testSoapUIIntegration(String testTitle, String ip, String countryCode, String countryName) throws Exception
	{
		// Put arguments to testdata properties, it will be used in SoapUI test.
		testdataProp.put("country_name", countryName);
		testdataProp.put("country_code", countryCode);
		testdataProp.put("ip", ip);
		testdataProp.store(new FileOutputStream(SOAP_PROJ_ROOT + "/Testdata.properties"), "Testdata");

		// Initialize SoapUI test runner.
		SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
		runner.setProjectFile(SOAP_PROJ_ROOT + "/_geoip-service.xml");
		// Set some configurations for the runner.
		runner.setEndpoint(configProp.getProperty("endpoint"));
		String[] sysProp = new String[] { "projroot=" + SOAP_PROJ_ROOT };
		runner.setSystemProperties(sysProp);
		Assert.assertTrue(runner.run());

		// Read temp properties that were populated by SoapUI test.
		tempProp = loadProp(SOAP_PROJ_ROOT + "/Temp.properties");
		Assert.assertEquals("USA", tempProp.get("country_code"));
		Assert.assertEquals("United States", tempProp.get("country_name"));
	}

	private Properties loadProp(String path) throws Exception
	{
		Properties prop = new Properties();
		prop.load(new FileReader(path));
		return prop;
	}
}