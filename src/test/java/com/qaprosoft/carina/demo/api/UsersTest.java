package com.qaprosoft.carina.demo.api;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.demo.api.GetUserMethods;
import com.qaprosoft.carina.core.demo.api.PostUserMethod;
import com.qaprosoft.carina.core.foundation.APITest;
import com.qaprosoft.carina.core.foundation.http.HttpResponseStatusType;

public class UsersTest extends APITest
{
	@Test
	public void testCreateUser()
	{
		PostUserMethod api = new PostUserMethod();
		api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		api.callAPI();
		api.validateResponse();
	}

	@Test
	public void testCreateUserMissingRequiredData()
	{
		PostUserMethod api = new PostUserMethod();
		api.getProperties().remove("name");
		api.getProperties().remove("username");
		api.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
		api.callAPI();
	}

	@Test
	public void testGetUsers()
	{
		GetUserMethods getUsersMethods = new GetUserMethods();
		getUsersMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
		getUsersMethods.callAPI();
		getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getUsersMethods.validateResponseAgainstJSONSchema("api/users/_get/rs.json");
	}
}
