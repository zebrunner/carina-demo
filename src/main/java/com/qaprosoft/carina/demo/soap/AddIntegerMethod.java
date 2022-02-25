package com.qaprosoft.carina.demo.soap;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@RequestTemplatePath(path = "api/soap/addinteger/rq.xml")
@ResponseTemplatePath(path = "api/soap/addinteger/rs.xml")
@ContentType(type = "text/xml")
public class AddIntegerMethod extends AbstractApiMethodV2 {

    public AddIntegerMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("soap_url"));
        setHeaders(String.format("SOAPAction=%s", "http://tempuri.org/SOAP.Demo.AddInteger"));
    }
}