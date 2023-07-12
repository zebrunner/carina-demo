package koval.api.dataTest;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

import static com.zebrunner.carina.utils.Configuration.getEnvArg;


@Endpoint(url="${base_url}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path="api/koval/testData/_getAll/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAllObjectsMethod extends AbstractApiMethodV2 {

public GetAllObjectsMethod()
{
    replaceUrlPlaceholder("base_url", getEnvArg("api_url_test"));
}

}
