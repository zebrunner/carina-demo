package koval.api.dataTest;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

import static com.zebrunner.carina.utils.Configuration.getEnvArg;


@Endpoint(url="${base_url}/${object_id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path="api/koval/testData/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetObjectByIDMethod extends AbstractApiMethodV2 {

public GetObjectByIDMethod(String objectId)
{
    replaceUrlPlaceholder("base_url", getEnvArg("api_url_test"));
    replaceUrlPlaceholder("object_id", objectId);

}



}
