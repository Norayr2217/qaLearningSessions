package main.com.test.enums;

public enum TestStatus {
    PASS("The test passed successfully."),
    FAIL("The test failed."),
    SKIPPED("The test was skipped.");

    private final String description;

    // Constructor
    TestStatus(String description) {
        this.description = description;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }
}