package main.com.test.autmationFrameworkIntroduction.singleton;

public class SignInTest {
    public static void main(String[] args) {
        SignInPage signInPage = SignInPage.getInstance("Singleton");

        try {
            System.out.println("Test 1");
            System.out.println("Driver - navigate to the sign in page");

            signInPage.signIn("Valid email", "Valid password");

        } finally {
            System.out.println("Driver - quit");
        }

        System.out.println("...............................");

        try {
            System.out.println("Test 2");
            System.out.println("Driver - navigate to the sign in page");

            signInPage.signIn("Valid email", "Invalid password");

        } finally {
            System.out.println("Driver - quit");
        }
    }
}
