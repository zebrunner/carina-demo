/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
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
 *******************************************************************************/
package com.zebrunner.carina.demo;

import java.lang.invoke.MethodHandles;

import com.zebrunner.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "knysh")
    public void testCreateUser() {
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testUpdateUser() {
        PutUserMethod api = new PutUserMethod(24);
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testGetUsers() {
        GetAllUsersMethod getUsersMethods = new GetAllUsersMethod();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/users/_get_all/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testGetUser() {
        GetUserByIdMethod getUsersMethod = new GetUserByIdMethod(23);
        getUsersMethod.callAPIExpectSuccess();
        getUsersMethod.validateResponse();
        getUsersMethod.validateResponseAgainstSchema("api/users/_get_by_id/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "knysh")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(24);
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }

}
