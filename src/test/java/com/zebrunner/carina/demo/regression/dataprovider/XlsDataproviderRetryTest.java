/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.regression.dataprovider;

import java.lang.invoke.MethodHandles;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;

public class XlsDataproviderRetryTest implements IAbstractTest, IAbstractDataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "qpsdemo")
    @XlsDataSourceParameters(path = "data_source/demo.xlsx", sheet = "Data", dsUid = "TestTitle", dsArgs = "Args")
    public void testMethod(String arg) {
        LOGGER.info("arg: " + arg);
        boolean isPassed = (new Random().nextInt(3) == 1) ? true : false;
        Assert.assertTrue(isPassed);
    }
    
}
