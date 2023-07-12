package koval.api.testData;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.api.dataTest.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class DataAPITest implements IAbstractTest {

    final String OBJECT_ID = "ff8081818905fd0e01892aa21b7315a2";
    @Test
    @MethodOwner(owner = "dkoval")
    public void getAllObjects() {
        GetAllObjectsMethod getAllObjectsMethod = new GetAllObjectsMethod();
        getAllObjectsMethod.callAPIExpectSuccess();
        getAllObjectsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAllObjectsMethod.validateResponseAgainstSchema("api/koval/testData/_getAll/rs.schema");
    }

    @Test
    @MethodOwner(owner = "dkoval")
    public void getObjectByID() {
        GetObjectByIDMethod getObjectByIDMethod = new GetObjectByIDMethod(OBJECT_ID);
        getObjectByIDMethod.callAPIExpectSuccess();
        getObjectByIDMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getObjectByIDMethod.validateResponseAgainstSchema("api/koval/testData/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "dkoval")
    public void postNewObject() {
        PostNewObjectMethod postNewObjectMethod = new PostNewObjectMethod();
        postNewObjectMethod.setProperties("api/koval/testData/object.properties");
        postNewObjectMethod.callAPIExpectSuccess();
        postNewObjectMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "dkoval")
    public void deleteObjectByID() {
        DeleteObjectMethod deleteObjectMethod = new DeleteObjectMethod(OBJECT_ID);
        deleteObjectMethod.setProperties("api/koval/testData/object.properties");
        deleteObjectMethod.callAPIExpectSuccess();
        deleteObjectMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "dkoval")
    public void updateObject() {
        PutObjectMethod putObjectMethod = new PutObjectMethod(OBJECT_ID);
        putObjectMethod.callAPIExpectSuccess();
        putObjectMethod.validateResponse();
    }

}

