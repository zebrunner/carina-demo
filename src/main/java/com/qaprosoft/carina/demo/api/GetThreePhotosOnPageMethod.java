package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;


@Endpoint(url = "${base_url}/search/photos?client_id=${token}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/three_photos/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetThreePhotosOnPageMethod extends AbstractApiMethodV2 {

    public GetThreePhotosOnPageMethod(){
        addParameter("query", "krakow");
        addParameter("page", "1");
        addParameter("per_page", "3");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_unsplash"));
        replaceUrlPlaceholder("token", Configuration.getEnvArg("access_token"));
    }
}
