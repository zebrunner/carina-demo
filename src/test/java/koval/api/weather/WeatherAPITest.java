package koval.api.weather;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class WeatherAPITest implements IAbstractTest {


    @Test
    @MethodOwner(owner="dkoval")
    public void getSenseBoxTest()
    {
        GetSenseBoxMethod getSenseBoxMethod = new GetSenseBoxMethod();
        getSenseBoxMethod.callAPIExpectSuccess();
        getSenseBoxMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getSenseBoxMethod.validateResponseAgainstSchema("api/koval/weather/_get/rs.json");

    }

}
