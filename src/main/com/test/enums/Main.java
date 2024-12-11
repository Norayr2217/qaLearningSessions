package main.com.test.enums;

public class Main {
    public static void main(String[] args) {
        for (TestStatus status : TestStatus.values()) {
            System.out.println(status + ": " + status.getDescription());
        }
    }
}