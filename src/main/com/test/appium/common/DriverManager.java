package test.appium.common;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverManager {

    private static final ThreadLocal<IOSDriver> driverThread = new ThreadLocal<>();

    private static final String DEVICE = System.getProperty("device", "realDevice");
    private IOSDriver driver;

    public final Supplier<IOSDriver> getRealDeviceDriver = () -> {
        synchronized (driverThread) {
            if (driverThread.get() == null) {
                XCUITestOptions options = new XCUITestOptions();
                options.setPlatformName("iOS");
                options.setPlatformVersion("17.6.1");
                options.setUdid("00008130-000E0D511E30001C");
                options.setAutomationName("XCUITest");
//                options.setBundleId("com.podcastle.ai");
                options.setBundleId("com.apple.calculator");
                options.setDeviceName("iPhone");
                options.setCapability("xcodeOrgId", "RXWNRH97G5");
                options.setCapability("xcodeSigningId", "iPhone Developer");
                options.setCapability("autoDismissAlerts", true);

                try {
                    driver = new IOSDriver(new URL("http://localhost:4723/"), options);
                    driverThread.set(driver);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            return driverThread.get();
        }
    };

    public Supplier<IOSDriver> getSimulatorDriver = () -> {
        synchronized (driverThread) {
            if (driverThread.get() == null) {
                XCUITestOptions options = new XCUITestOptions();
                options.setPlatformName("iOS");
                options.setPlatformVersion("17.5");
                options.setAutomationName("XCUITest");
                options.setBundleId("com.podcastle.ai");
                options.setDeviceName("iPhone 15 Pro");

                try {
                    driver = new IOSDriver(new URL("http://localhost:4723/"), options);
                    driverThread.set(driver);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            return driverThread.get();
        }
    };

    private final Map<String, Supplier<IOSDriver>> MAP = new HashMap<>();

    {
        MAP.put("realDevice", getRealDeviceDriver);
        MAP.put("simulator", getSimulatorDriver);
    }

    public static DriverManager get() {
        return new DriverManager();
    }

    public IOSDriver getDriver() {
        return MAP.get(DEVICE).get();
    }

    public void quitDriver(IOSDriver driver) {
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }
}