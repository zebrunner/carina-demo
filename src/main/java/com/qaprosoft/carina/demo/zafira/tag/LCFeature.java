package com.qaprosoft.carina.demo.zafira.tag;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = java.lang.annotation.ElementType.METHOD)
public @interface LCFeature {
    Feature value() default Feature.UNKNOWN;
}
