package com.rhcloud.tothought.web.spring.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PageableRequestMapping {
	String pathVariable() default "/";
}
