package main.com.test.annotiations;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        // Inspect the TestSuite class
        Class<TestSuite> testClass = TestSuite.class;

        // Loop through methods to find annotations
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TestInfo.class)) {
                // Retrieve the TestInfo annotation
                TestInfo annotation = method.getAnnotation(TestInfo.class);

                // Print annotation details
                System.out.println("Method: " + method.getName());
                System.out.println("Author: " + annotation.author());
                System.out.println("Description: " + annotation.description());
                System.out.println("Created Date: " + annotation.createdDate());
                System.out.println("-------------------------");
            }
        }
    }

}