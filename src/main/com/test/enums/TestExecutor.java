package main.com.test.enums;

import static main.com.test.enums.TestStatus.*;

public class TestExecutor {
    public static void executeTest(String testName, TestStatus status) {
        switch (status) {
            case PASS:
                System.out.println("✔ " + testName + " - Test Passed!");
                break;
            case FAIL:
                System.out.println("✘ " + testName + " - Test Failed. Needs investigation.");
                break;
            case SKIPPED:
                System.out.println("⚠ " + testName + " - Test Skipped.");
                break;
        }
    }

    public static void main(String[] args) {
        executeTest("Login Test", PASS);
        executeTest("Logout Test", FAIL);
        executeTest("Signup Test", SKIPPED);
    }
}