package main.com.test.abstractVSInterface;

class APIAutomationTest extends BaseTest implements TestLogger {
    @Override
    void executeTest() {
        System.out.println("Executing API test...");
    }
    
    @Override
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}