package com.zebrunner.carina.demo.api;


import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.binding.TemplateFactory;

public class UserTemplateImpl implements UserTemplate {

    private final UserTemplate userTemplate;

    public UserTemplateImpl() {
        this.userTemplate = TemplateFactory.prepareTemplate(UserTemplate.class);
    }

    @Override
    public AbstractApiMethodV2 create(String rqPath, String rsPath, String propsPath) {
        AbstractApiMethodV2 apiMethod = userTemplate.create(rqPath, rsPath, propsPath);
        apiMethod.addProperty("prop", "val");
        return apiMethod;
    }

    @Override
    public AbstractApiMethodV2 getAll() {
        AbstractApiMethodV2 apiMethod = userTemplate.getAll();
        apiMethod.addCookie("cookie", "val");
        return apiMethod;
    }

    @Override
    public AbstractApiMethodV2 deleteById(Long id) {
        AbstractApiMethodV2 apiMethod = userTemplate.deleteById(id);
        apiMethod.setHeader("header", "val");
        return apiMethod;
    }
}