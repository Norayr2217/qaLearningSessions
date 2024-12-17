package main.com.test.autmationFrameworkIntroduction.singleton;

public class SignInPage {
    // Step 1: Create a private static instance of the class
    private static SignInPage instance;
    private String single;
    private String usernameField = "username";
    private String passwordField = "password";
    private String signInButton = "signInButton";

    // Step 2: Make the constructor private so that it cannot be instantiated from outside
    private SignInPage(String single) {
        this.single = single;
    }

    // Step 3: Provide a public method to get the single instance of the class
    public static synchronized SignInPage getInstance(String single) {
        if (instance == null) {
            instance = new SignInPage(single);
        }
        System.out.println(single + " design pattern");
        return instance;
    }

    // Method to sign in
    public void signIn(String username, String password) {

        System.out.println("Enter " + username + " in the " + usernameField + " field.");
        System.out.println("Enter " + password + " in the " + passwordField + " field.");
        System.out.println("Click the " + signInButton + " button.");
    }
}
