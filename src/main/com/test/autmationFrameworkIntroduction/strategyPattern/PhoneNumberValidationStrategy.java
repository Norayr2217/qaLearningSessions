package main.com.test.autmationFrameworkIntroduction.strategyPattern;

public class PhoneNumberValidationStrategy implements ValidationStrategy{
    @Override
    public boolean validate(String data) {
        return data != null && data.matches("\\d{10}");
    }
}

