package com.qaprosoft.carina.core.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PatchPostsMethod extends AbstractApiMethodV2 {

    public PatchPostsMethod() {
        super("api/users/_patch/rq.json", "api/users/_patch/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
