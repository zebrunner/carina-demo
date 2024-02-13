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

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.demo.api.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APIProductsTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "knysh")
    public void testGetProducts() {
        GetAllProductsMethod getProductsMethods = new GetAllProductsMethod();
        getProductsMethods.callAPIExpectSuccess();
        getProductsMethods.validateResponse();
        getProductsMethods.validateResponseAgainstSchema("api/users/_get_products/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testGetProduct() {
        GetProductByIdMethod getProductMethod = new GetProductByIdMethod(1);
        getProductMethod.callAPIExpectSuccess();
        getProductMethod.validateResponse();
        getProductMethod.validateResponseAgainstSchema("api/users/_get_product_by_id/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testGetProductsFromSearch() {
        GetProductsFromSearchMethod getProductMethod = new GetProductsFromSearchMethod();
        getProductMethod.callAPIExpectSuccess();
        getProductMethod.validateResponse();
        getProductMethod.validateResponseAgainstSchema("api/users/_get_product_by_id/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testGetProductCategories() {
        GetProductCategoriesMethod getProductsCategories = new GetProductCategoriesMethod();
        getProductsCategories.callAPIExpectSuccess();
        getProductsCategories.validateResponse();
        getProductsCategories.validateResponseAgainstSchema("api/users/_get_product_categories/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testGetProductsOfCategory() {
        GetProductsOfCategoryMethod getProductsCategory = new GetProductsOfCategoryMethod("smartphones");
        getProductsCategory.callAPIExpectSuccess();
        getProductsCategory.validateResponse();
        getProductsCategory.validateResponseAgainstSchema("api/users/_get_products_of_category/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testAddProduct() {
        PostProductMethod api = new PostProductMethod();
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }


    // didn't work
    @Test()
    @MethodOwner(owner = "knysh")
    public void testUpdateProduct() {
        PutProductMethod api = new PutProductMethod(7);
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    // didn't work
    @Test()
    @MethodOwner(owner = "knysh")
    public void testUpdatePatchProduct() {
        PatchProductMethod api = new PatchProductMethod(7);
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "knysh")
    @TestPriority(Priority.P1)
    public void testDeleteProduct() {
        DeleteProductMethod deleteProductMethod = new DeleteProductMethod(8);
        deleteProductMethod.callAPIExpectSuccess();
        deleteProductMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "knysh")
    public void testGetProductsWithAuthToken() {
        LoginUserMethod login = new LoginUserMethod();
        Response rs = login.callAPI();
        String actualRsBody = rs.asString();
        String token = JsonPath.from(actualRsBody).getString("token");
        login.callAPIExpectSuccess();
        ProvideTokenInBearerMethod provide = new ProvideTokenInBearerMethod(token);
        provide.callAPIExpectSuccess();
        GetProductsWithAuthTokenMethod get= new GetProductsWithAuthTokenMethod(token);
        get.callAPIExpectSuccess();
        get.validateResponse();
    }
}
