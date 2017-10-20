/*
 * Copyright 2013-2016 QAPROSOFT (http://qaprosoft.com/).
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
package com.qaprosoft.carina.demo;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.demo.api.DeleteUserMethod;
import com.qaprosoft.carina.core.demo.api.GetUserMethods;
import com.qaprosoft.carina.core.demo.api.PostUserMethod;
import com.qaprosoft.carina.core.demo.util.PO;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.performance.Timer;

import junit.framework.Assert;

/**
 * This sample shows how create web test.
 * 
 * @author Alex Khursevich
 */
public class APISampleTest extends AbstractTest
{
	public static int n = 0;
	@Test(description = "JIRA#DEMO-0001")
	public void testCreateUser()throws InterruptedException
	{
		if (n++ < 2) {
			Assert.fail("attempt: " + n);
		}
		Timer.start(PO.CREATE_USER);
		PostUserMethod api = new PostUserMethod();
		api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		api.callAPI();
		api.validateResponse();
		Timer.stop(PO.CREATE_USER);
	}

	@Test(description = "JIRA#DEMO-0002")
	public void testCreateUserMissingSomeFields()throws InterruptedException
	{
		PostUserMethod api = new PostUserMethod();
		api.getProperties().remove("name");
		api.getProperties().remove("username");
		api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		api.callAPI();
		api.validateResponse();
	}

	@Test(description = "JIRA#DEMO-0003")
	public void testGetUsers() throws InterruptedException
	{
		Timer.start(PO.GET_USER);
		GetUserMethods getUsersMethods = new GetUserMethods();
		getUsersMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
		getUsersMethods.callAPI();
		getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getUsersMethods.validateResponseAgainstJSONSchema("api/users/_get/rs.schema");
		Timer.stop(PO.GET_USER);
	}

	@Test(description = "JIRA#DEMO-0004")
	public void testDeleteUsers() throws InterruptedException
	{
		Timer.start(PO.DELETE_USER);
		DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
		deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		deleteUserMethod.callAPI();
		deleteUserMethod.validateResponse();
		Timer.stop(PO.DELETE_USER);
	}
}