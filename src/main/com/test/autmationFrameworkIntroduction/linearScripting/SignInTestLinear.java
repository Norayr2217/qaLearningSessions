package main.com.test.autmationFrameworkIntroduction.linearScripting;

public class SignInTestLinear {
    public static void main(String[] args) {
        System.out.println("Create a driver");

        try {
            System.out.println("Driver - navigate to the sign in page.");

            String username = "username";
            String password = "password";
            String signIn = "signInButton";

            System.out.println("Enter username in the " + username + " field.");
            System.out.println("Enter password in the " + password + " field.");
            System.out.println("Click the " + signIn + " button.");

                System.out.println("Sign-in successful.");


        } finally {
            System.out.println("Driver - quit");
        }
    }
}
