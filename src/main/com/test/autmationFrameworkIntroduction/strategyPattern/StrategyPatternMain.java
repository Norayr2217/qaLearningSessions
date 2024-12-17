package main.com.test.autmationFrameworkIntroduction.strategyPattern;

public class StrategyPatternMain {
    public static void main(String[] args) {
        DataValidator validator = new DataValidator();

        validator.setStrategy(new EmailValidationStrategy());
        System.out.println("Email validation: " + validator.validateData("example@example.com"));
        System.out.println("Email validation: " + validator.validateData("invalid-email"));

        validator.setStrategy(new PhoneNumberValidationStrategy());
        System.out.println("Phone number validation: " + validator.validateData("1234567890"));
        System.out.println("Phone number validation: " + validator.validateData("12345"));
    }
}