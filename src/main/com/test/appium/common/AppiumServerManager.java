package test.appium.common;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServerManager {
    private AppiumDriverLocalService service;

    public void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withIPAddress("localhost")
                .usingPort(4723)
                .withAppiumJS(new File("/Users/norayrsargsyan/.nvm/versions/node/v20.15.0/bin/appium"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Appium server started on " + service.getUrl());
    }

    public void stopServer() {
        if (service != null) {
            service.stop();
            System.out.println("Appium server stopped");
        }
    }
}