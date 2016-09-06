package com.qaprosoft.carina.core.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.demo.api.GetUsersMethods;
import com.qaprosoft.carina.core.demo.api.PostUsersMethods;
import com.qaprosoft.carina.core.foundation.APITest;
import com.qaprosoft.carina.core.foundation.http.HttpResponseStatusType;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class UserTests extends APITest {

    private static final String POST_RQ_URL = "API_data/_post/rq.json";
    private static final String RS_SCHEMA = "API_data/_get/rs_schema.json";
    private static final String POST_RS_URL = "API_data/_post/rs.json";
    private static final String POST_RQ_PROP = "API_data/_post/rq.properties";

    @Test
    public void createUser() {
        PostUsersMethods postUsersMethods = new PostUsersMethods(POST_RQ_URL, POST_RS_URL, POST_RQ_PROP);
        postUsersMethods.callAPI();
        postUsersMethods.validateResponse();
    }

    @Test
    public void createUsersN() {
        PostUsersMethods postUsersMethods = new PostUsersMethods(POST_RQ_URL, POST_RS_URL, POST_RQ_PROP);
        postUsersMethods.getProperties().remove("name");
        postUsersMethods.getProperties().remove("username");
        postUsersMethods.callAPI();
        postUsersMethods.validateResponse();
    }

    @Test
    public void getUsers() {
        GetUsersMethods getUsersMethods = new GetUsersMethods();
        getUsersMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUsersMethods.callAPI();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstJSONSchema(RS_SCHEMA);
    }
}
