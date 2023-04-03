package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/collections/${id}/photos?client_id=${token}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCheckDefaultPaginationMethod extends AbstractApiMethodV2 {

    public GetCheckDefaultPaginationMethod(int id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_unsplash"));
        replaceUrlPlaceholder("id", String.valueOf(id));
        replaceUrlPlaceholder("token", Configuration.getEnvArg("access_token"));
    }
}
