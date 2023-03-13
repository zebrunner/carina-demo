package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.GetPhotosUnauthorizedMethod;
import com.qaprosoft.carina.demo.api.GetPhotosMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APICarinaTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "yana-glt")
    public void testGetPhotos() {
        GetPhotosMethod getPhotosMethod = new GetPhotosMethod();
        getPhotosMethod.callAPIExpectSuccess();
        getPhotosMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPhotosMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "yana-glt")
    public void testGetPhotosUnauthorized() {
        GetPhotosUnauthorizedMethod getPhotosUnauthorizedMethod = new GetPhotosUnauthorizedMethod();
        getPhotosUnauthorizedMethod.callAPIExpectSuccess();
        getPhotosUnauthorizedMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPhotosUnauthorizedMethod.validateResponseAgainstSchema("api/photos/_get/rs_unauthorized.schema");
    }

}
