package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/collections/${id}/photos?client_id=${token}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/collection_photos/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCollectionsPhotosByIdMethod extends AbstractApiMethodV2 {

    public GetCollectionsPhotosByIdMethod(){
        String id = "9242294";
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_unsplash"));
        replaceUrlPlaceholder("id", id);
        replaceUrlPlaceholder("token", Configuration.getEnvArg("access_token"));
    }
}
