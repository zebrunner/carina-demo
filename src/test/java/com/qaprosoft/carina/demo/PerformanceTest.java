package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.operations.Operation;
import org.testng.annotations.Test;

public class PerformanceTest extends AbstractTest {


    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "qpsdemo")
    public void testZafiraPerfomance() {

        Operation operation = new Operation(getDriver());
        operation.loginOperation();
        operation.passwordOperation();
        operation.searchOperation();

    }

}
