package main.com.test.annotiations;

public class TestSuite {

    @TestInfo(
        author = "Norayr",
        description = "Verifies the login functionality.",
        createdDate = "2024-12-09"
    )
    public void loginTest() {
        System.out.println("Executing login test...");
    }

    @TestInfo(author = "Norayr", description = "Verifies the logout functionality.", createdDate = "2024-12-09")
    public void logoutTest() {
        System.out.println("Executing logout test...");
    }
}
