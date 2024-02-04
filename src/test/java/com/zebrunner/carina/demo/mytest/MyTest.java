package com.zebrunner.carina.demo.mytest;

import com.google.common.reflect.TypeToken;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.api.DeletePostByIdMethod;
import com.zebrunner.carina.demo.api.GetPostsMethod;
import com.zebrunner.carina.demo.api.PostPostMethod;
import com.zebrunner.carina.demo.db.models.Post;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class MyTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Pavel L.")
    public void getPostsTest() {
        LOGGER.debug("Start of getPostsTest");
        GetPostsMethod getPostsMethods = new GetPostsMethod();
        getPostsMethods.callAPIExpectSuccess();
        getPostsMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostsMethods.validateResponseAgainstSchema("api/posts/_get/posts.schema");
        LOGGER.debug("End of getPostsTest");
    }

    @Test()
    @MethodOwner(owner = "Pavel L.")
    public void deletePostTest() {
        LOGGER.debug("Start of addNewPostTest");
        GetPostsMethod getPostsMethods = new GetPostsMethod();
        List<Post> posts = getPostsMethods.callAPIExpectSuccess().body().as(new TypeToken<ArrayList<Post>>(){}.getType());
        Post postToDelete = posts.get(posts.size() - 1);
        DeletePostByIdMethod deletePostByIdMethod = new DeletePostByIdMethod(postToDelete.getId());
        Post deletedPost = deletePostByIdMethod.callAPIExpectSuccess().body().as(Post.class);
        Assert.assertEquals(deletedPost, new Post(), "Deleted post should be equal to expected one.");
        LOGGER.debug("End of addNewPostTest");
    }

    @Test()
    @MethodOwner(owner = "Pavel L.")
    public void addNewPostTest() {
        LOGGER.debug("Start of createNewPostTest");
        PostPostMethod postPostMethod = new PostPostMethod();
        Post postToCreate = new Post(1L, 101L, "Test automation", "Some text here");
        postPostMethod.setRequestBody(postToCreate);
        Post postCreated = postPostMethod.callAPIExpectSuccess().body().as(Post.class);
        Assert.assertEquals(postCreated, postToCreate, "Created post should be equal to expected one.");
        LOGGER.debug("End of createNewPostTest");
    }
}
