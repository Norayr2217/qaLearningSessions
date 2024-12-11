package main.com.test.annotiations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define a custom annotation for test metadata
@Retention(RetentionPolicy.RUNTIME) // Retain at runtime for reflection
@Target(ElementType.METHOD)         // Applicable to methods
public @interface TestInfo {
    String author();
    String description();
    String createdDate();
}