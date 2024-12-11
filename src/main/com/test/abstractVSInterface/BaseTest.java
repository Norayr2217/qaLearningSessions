package main.com.test.abstractVSInterface;

abstract class BaseTest {
    void setup() {
        System.out.println("Common setup for tests.");
    }
    abstract void executeTest();
}