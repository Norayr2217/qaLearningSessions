package main.com.test.autmationFrameworkIntroduction.strategyPattern;

public class DataValidator {
    private ValidationStrategy strategy;

    public void setStrategy(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validateData(String data) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.validate(data);
    }
}
