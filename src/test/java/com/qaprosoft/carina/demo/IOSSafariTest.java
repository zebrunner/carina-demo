/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
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
 */
package com.qaprosoft.carina.demo;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.SaucePage;

public class IOSSafariTest implements IAbstractTest, IMobileUtils {
    @Test
    public void safariTest() {
        SaucePage saucePage = new SaucePage(getDriver());
        saucePage.openURL("http://saucelabs.com/test/guinea-pig");
        
        saucePage.verifyElementText();
        saucePage.sendComment();
    }

}