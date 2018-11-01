package com.qaprosoft.carina.demo.zafira.tag;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.lang.reflect.Method;


public class DemoFeatureManager {
    protected static final Logger LOGGER = Logger.getLogger(DemoFeatureManager.class);

    private DemoFeatureManager() {
    }

    public static String getFeature(ITestResult result) {

        // Get a handle to the class and method
        Class<?> testClass;
        String feature = getSuiteFeature(result.getTestContext());

        try {
            testClass = Class.forName(result.getMethod().getTestClass().getName());

            // We can't use getMethod() because we may have parameterized tests
            // for which we won't know the matching signature
            String methodName = result.getMethod().getMethodName();
            Method testMethod = null;
            Method[] possibleMethods = testClass.getMethods();
            for (Method possibleMethod : possibleMethods) {
                if (possibleMethod.getName().equals(methodName)) {
                    testMethod = possibleMethod;
                    break;
                }
            }

            if (testMethod != null && testMethod.isAnnotationPresent(DemoFeature.class)) {
                DemoFeature methodAnnotation = testMethod.getAnnotation(DemoFeature.class);
                feature = methodAnnotation.value().toString();

                LOGGER.debug("Method '" + testMethod + "' feature is: " + feature);
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return validateFeature(feature);
    }


    private static String validateFeature(String feature) {
        for(Feature elem : Feature.values()) {
            if(elem.toString().equalsIgnoreCase(feature)) {
                return elem.toString();
            }
        }
        return "UNKNOWN";
    }

    private static String getSuiteFeature(ITestContext context) {
        String feature = context.getSuite().getParameter("suiteFeature");
        LOGGER.debug("suiteFeature is: " + feature);
        if (feature == null) {
            feature = "";
        }
        return feature;
    }
}
