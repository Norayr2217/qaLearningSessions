package main.com.test.autmationFrameworkIntroduction.strategyPattern;

public class EmailValidationStrategy implements ValidationStrategy {
    @Override
    public boolean validate(String data) {
        return data != null && data.contains("@");
    }
}
