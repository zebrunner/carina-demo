package com.qaprosoft.carina.demo.soap;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@RequestTemplatePath(path = "api/soap/lookupcity/rq.xml")
@ResponseTemplatePath(path = "src/test/resources/api/soap/lookupcity/rs.xml")
@ContentType(type = "text/xml")
public class LookupCityMethod extends AbstractApiMethodV2 {

    public LookupCityMethod() {
        replaceUrlPlaceholder("base_url",Configuration.getEnvArg("soap_url"));
        setHeaders(String.format("SOAPAction=%s", "http://tempuri.org/SOAP.Demo.LookupCity"));
    }
}