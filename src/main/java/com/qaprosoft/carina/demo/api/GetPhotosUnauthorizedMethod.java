package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/search/photos",
        methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/photos/_get/rs_unauthorized.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.UNAUTHORIZED_401)
public class GetPhotosUnauthorizedMethod extends AbstractApiMethodV2 {

    public GetPhotosUnauthorizedMethod() {
        addParameter("query", "krakow");
        addParameter("page", "1");
        addParameter("per_page", "1");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_unsplash"));

    }
}
