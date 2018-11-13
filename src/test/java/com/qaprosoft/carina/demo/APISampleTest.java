/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.report.qtest.QTestTestCase;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.api.DeleteUserMethod;
import com.qaprosoft.carina.demo.api.GetUserMethods;
import com.qaprosoft.carina.demo.api.PostUserMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest extends AbstractTest {

    @Test(description = "JIRA#DEMO-0001")
    @MethodOwner(owner = "qpsdemo")
    @TestRailCases(testCasesId = "1")
    @TestRailCases(testCasesId = "10", platform = "API")
    @QTestTestCase(id = "1")
    @QTestTestCase(id = "100", platform = "Android")
    @QTestTestCase(id = "200", platform = "API")
    public void testCreateUser() throws Exception {
        setTestRailCase("4555,54545");
        PostUserMethod api = new PostUserMethod();
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponse();
    }

    @Test(description = "JIRA#DEMO-0002")
    @MethodOwner(owner = "qpsdemo")
    @TestRailCases(testCasesId = "2")
    @QTestTestCase(id = "2")
    public void testCreateUserMissingSomeFields() throws Exception {
        PostUserMethod api = new PostUserMethod();
        api.getProperties().remove("name");
        api.getProperties().remove("username");
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponse();
    }

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "qpsdemo")
    @TestRailCases(testCasesId = "3")
    @TestRailCases(testCasesId = "4")
    @QTestTestCase(id = "3")
    @QTestTestCase(id = "4")
    public void testGetUsers() {
        GetUserMethods getUsersMethods = new GetUserMethods();
        getUsersMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUsersMethods.callAPI();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstJSONSchema("api/users/_get/rs.schema");
    }

    @Test(description = "JIRA#DEMO-0004")
    @MethodOwner(owner = "qpsdemo")
    @TestRailCases(testCasesId = "5,9,65656")
    @TestRailCases(testCasesId = "6")
    @TestRailCases(testCasesId = "7")
    @QTestTestCase(id = "5")
    @QTestTestCase(id = "6")
    @QTestTestCase(id = "7")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }

}
