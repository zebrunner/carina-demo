package carina.learning;

import carina.learning.api.products.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APIProductsTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetProducts() {
        GetAllProductsMethod getProductsMethods = new GetAllProductsMethod();
        getProductsMethods.callAPIExpectSuccess();
        getProductsMethods.validateResponse();
        getProductsMethods.validateResponseAgainstSchema("api/products/_get_products/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetProduct() {
        GetProductByIdMethod getProductMethod = new GetProductByIdMethod(1);
        getProductMethod.callAPIExpectSuccess();
        getProductMethod.validateResponse();
        getProductMethod.validateResponseAgainstSchema("api/products/_get_product_by_id/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetProductsFromSearch() {
        GetProductsFromSearchMethod getProductMethod = new GetProductsFromSearchMethod();
        getProductMethod.callAPIExpectSuccess();
        getProductMethod.validateResponse();
        getProductMethod.validateResponseAgainstSchema("api/products/_get_product_by_id/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetProductCategories() {
        GetProductCategoriesMethod getProductsCategories = new GetProductCategoriesMethod();
        getProductsCategories.callAPIExpectSuccess();
        getProductsCategories.validateResponse();
        getProductsCategories.validateResponseAgainstSchema("api/products/_get_product_categories/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetProductsOfCategory() {
        GetProductsOfCategoryMethod getProductsCategory = new GetProductsOfCategoryMethod("smartphones");
        getProductsCategory.callAPIExpectSuccess();
        getProductsCategory.validateResponse();
        getProductsCategory.validateResponseAgainstSchema("api/products/_get_products_of_category/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testAddProduct() {
        PostProductMethod api = new PostProductMethod();
        api.setProperties("api/products/product.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testUpdateProduct() {
        PutProductMethod api = new PutProductMethod(7);
        api.setProperties("api/products/product.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testUpdatePatchProduct() {
        PatchProductMethod api = new PatchProductMethod(7);
        api.setProperties("api/products/product.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    @TestPriority(Priority.P1)
    public void testDeleteProduct() {
        DeleteProductMethod deleteProductMethod = new DeleteProductMethod(8);
        deleteProductMethod.callAPIExpectSuccess();
        deleteProductMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetProductsWithAuthToken() {
        PostLoginUserMethod login = new PostLoginUserMethod();
        Response rs = login.callAPI();
        String actualRsBody = rs.asString();
        String token = JsonPath.from(actualRsBody).getString("token");
        login.callAPIExpectSuccess();
        GetTokenInBearerMethod provide = new GetTokenInBearerMethod(token);
        provide.callAPIExpectSuccess();
        GetProductsWithAuthTokenMethod get= new GetProductsWithAuthTokenMethod(token);
        get.callAPIExpectSuccess();
        get.validateResponse();
    }
}
