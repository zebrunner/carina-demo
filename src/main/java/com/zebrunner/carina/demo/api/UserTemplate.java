package com.zebrunner.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.annotation.method.DeleteMethod;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@EndpointTemplate(url = "${config.env.api_url}/users")
public interface UserTemplate {

    @EndpointTemplateMethod(url = "/",methodType = HttpMethodType.POST)
    AbstractApiMethodV2 create(@RequestTemplatePath.Value String rqPath,
                               @ResponseTemplatePath.Value String rsPath,
                               @PropertiesPath.Value String prosPath);

    @EndpointTemplateMethod(url = "/",methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/users/_get/rs.json")
    @PropertiesPath(path = "api/users/user.properties")
    AbstractApiMethodV2 getAll();

    @DeleteMethod(url = "/${id}")
    @RequestTemplatePath(path = "api/users/_delete/rq.json")
    @ResponseTemplatePath(path = "api/users/_delete/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 deleteById(@PathParam(key = "id") Long id);
}
