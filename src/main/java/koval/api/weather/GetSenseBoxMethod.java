package koval.api.weather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;


import static com.zebrunner.carina.utils.Configuration.getEnvArg;


@Endpoint(url="${base_url}/5391be52a8341554157792e6", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path="api/koval/weather/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetSenseBoxMethod extends AbstractApiMethodV2 {

    public GetSenseBoxMethod(){
        replaceUrlPlaceholder("base_url", getEnvArg("api_url_weather"));
    }

}
