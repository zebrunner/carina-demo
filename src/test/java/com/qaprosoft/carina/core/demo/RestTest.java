/*
 * Copyright 2013 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.core.demo;

import org.hamcrest.Matchers;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.demo.api.GeoIPGetMethod;
import com.qaprosoft.carina.core.foundation.APITest;
import com.qaprosoft.carina.core.foundation.http.HttpResponseStatusType;

public class RestTest extends APITest
{
	@Test(dataProvider="excel_ds")
	@Parameters({"testTitle", "ip", "countryCode", "countryName", "laliture", "longtitude"})
	public void testRestService(String testTitle, String ip, String countryCode, String countryName, String laliture, String longtitude)
	{
		GeoIPGetMethod geoIPGetMethod = apiMethodBuilder.build(new GeoIPGetMethod("xml", ip));
		// Set response expectations
		geoIPGetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		geoIPGetMethod.expectInResponse(Matchers.hasXPath("//Ip", Matchers.equalTo(ip)));
		geoIPGetMethod.expectInResponse(Matchers.hasXPath("//CountryCode", Matchers.equalTo(countryCode)));
		geoIPGetMethod.expectInResponse(Matchers.hasXPath("//CountryName", Matchers.equalTo(countryName)));
		geoIPGetMethod.expectInResponse(Matchers.hasXPath("//Latitude", Matchers.equalTo(laliture)));
		geoIPGetMethod.expectInResponse(Matchers.hasXPath("//Longitude", Matchers.equalTo(longtitude)));
		// Call REST service method
		geoIPGetMethod.call();
	}
}