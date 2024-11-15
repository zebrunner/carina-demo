package com.zebrunner.carina.demo.api.mycases;

import com.beust.jcommander.Parameter;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Parameters;

@Endpoint(url = "${config.env.api_url}/posts",methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/posts/_post/rq.json")
@ResponseTemplatePath(path = "api/posts/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostPostMethod extends AbstractApiMethodV2 {

    public PostPostMethod(){
        super("api/posts/_post/rq.json","api/posts/_post/rs.json","api/posts/post.properties");
    }
}
