package com.zebrunner.carina.demo.api.mycases;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.api_url}/posts",methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/posts/_get/all/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAllPostsMethod extends AbstractApiMethodV2 {
    public GetAllPostsMethod(){}
}
