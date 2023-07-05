package koval.api.dataTest;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/koval/testData/_post/rq.json")
@ResponseTemplatePath(path = "api/koval/testData/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostNewObjectMethod extends AbstractApiMethodV2 {

    public PostNewObjectMethod() {
        super("api/koval/testData/_post/rq.json", "api/koval/testData/_post/rs.json", "api/koval/testData/object.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_test"));
    }

}
