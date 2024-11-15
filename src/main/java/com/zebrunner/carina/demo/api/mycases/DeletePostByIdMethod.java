package com.zebrunner.carina.demo.api.mycases;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.api_url}/posts/1",methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/posts/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeletePostByIdMethod extends AbstractApiMethodV2 {

    public DeletePostByIdMethod(){}
}
