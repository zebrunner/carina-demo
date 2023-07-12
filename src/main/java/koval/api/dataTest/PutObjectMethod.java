package koval.api.dataTest;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;


@Endpoint(url = "${base_url}/${object_id}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/koval/testData/_put/rq.json")
@ResponseTemplatePath(path = "api/koval/testData/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutObjectMethod extends AbstractApiMethodV2 {

    public PutObjectMethod(String objectID) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_test"));
        replaceUrlPlaceholder("object_id", objectID);

    }

}

