package com.zebrunner.carina.demo;

import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.api.PostUserMethod;
import com.zebrunner.carina.demo.api.UserTemplateImpl;
import com.zebrunner.carina.demo.api.mycases.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTestCase {


    @Test
    @MethodOwner(owner = "emir")
    public void getPostById(){
        GetPostByIdMethod api = new GetPostByIdMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT);
        api.validateResponseAgainstSchema("api/posts/_get/by_post_id/rs.schema");
    }

    @Test
    @MethodOwner(owner = "emir")
    public void getAllPosts(){
        GetAllPostsMethod api = new GetAllPostsMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/posts/_get/all/rs.schema");
    }

    @Test
    @MethodOwner(owner = "emir")
    public void getCommentsByPostId(){
        GetPostCommentsByPostIdMethod api = new GetPostCommentsByPostIdMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT,JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/posts/_get/comments_by_post_id/rs.schema");
    }

    @Test
    @MethodOwner(owner = "emir")
    public void createPost(){
        PostPostMethod api = new PostPostMethod();
        api.setProperties("api/posts/post.properties");

        AtomicInteger counter = new AtomicInteger(0);
//        api.callAPIExpectSuccess();
        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL) //Set a log strategy which is gonna use logger to show each retry
                .peek(called-> counter.getAndIncrement()) //Each time execute the call to the api increment the counter +1
                .until(called -> counter.get() == 1) // stop condition, if counter is in the 3rd retry it stop the retry
                .pollEvery(2, ChronoUnit.SECONDS) // Set an interval of time between each retry
                .stopAfter(10,ChronoUnit.SECONDS) // Set a specific time to wait to finish the retry, if time is over it will finish the execution even if its "until" counter has not finished yet
                .execute(); // execute the retry strategies

    }

    @Test(priority = 1)
    @MethodOwner(owner = "emir")
    public void deletePostById(){
        DeletePostByIdMethod api = new DeletePostByIdMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }


//    @Test(priority = 1)
//    void setup(){
//        System.out.println("I am inside setup");
//    }
//
//    @Test(priority = 2)
//    void testSteps(){
//        System.out.println("I am inside testSteps");
//    }
//
//    @Test(priority = 3)
//    void tearDown(){
//        System.out.println("I am inside tearDown");
//    }
//
//    @Test
//    @MethodOwner(owner = "emir")
//    public void testCreateUser(){
//        //UserTemplate userTemplate = TemplateFactory.prepareTemplate(UserTemplate.class);
//        UserTemplateImpl userTemplate = new UserTemplateImpl();
//        PostUserMethod api = (PostUserMethod) userTemplate.create("api/users/_post/rq.json", "api/users/_post/rs.json", "api/users/user.properties");
//        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
//        api.callAPI();
//        api.validateResponse();
//    }

}
