package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/search/collections?query=krakow&page=1&per_page=1&client_id=oZqNRI9G64U6XQonRp5aZduKHySCnEB55zH_Xuko-ZI", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/collections/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCollectionsMethod extends AbstractApiMethodV2 {

    public GetCollectionsMethod(){
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_unsplash"));

    }
}
