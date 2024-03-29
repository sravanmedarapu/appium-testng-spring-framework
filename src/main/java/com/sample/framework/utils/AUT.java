package com.sample.framework.utils;

import com.sample.framework.config.AndroidCapabilities;
import com.sample.framework.config.IDriver;
import com.sample.framework.config.IOSCapabilities;
import com.sample.framework.config.Capabilities;
import com.sample.framework.config.Platform;
import com.sample.framework.properties.Environment;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.proxy.NotImplementedException;
import lombok.Getter;
import org.openqa.selenium.MutableCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@Component
public abstract class AUT extends AbstractTestNGSpringContextTests implements IDriver {
    private AppiumService appiumService;
    private Capabilities capabilities;

    @Getter
    protected AppiumDriver driver;

    @Autowired
    Environment properties;

    public void startAppiumServer() throws Exception {
        appiumService = new AppiumService(properties);
        capabilities = initCapabilities(properties);
        appiumService.startAppiumServer();
    }

    public void stopAppiumServer() throws Exception {
        if (appiumService == null) {
            throw new Exception("Appium Server not launched, please make sure to startAppiumServer before stopping");
        }
        appiumService.stopService();
    }

    public MutableCapabilities getCapabilities() {
        return capabilities.getCapabilities();

    }

    @Override
    public AppiumDriver setUpDriver(MutableCapabilities capabilities) throws Exception {
        if (properties.getPlatformName().equalsIgnoreCase(Platform.IOS.toString())) {
            throw new NotImplementedException();
        }
        driver = new AndroidDriver(appiumService.getServerUrl(), capabilities);

        return driver;
    }

    @Override
    public void tearDownDriver() throws Exception {
        if (driver == null) {
            throw new Exception("Appium Driver not initialized.");
        }
        driver.quit();
    }

    private Capabilities initCapabilities(Environment properties) {
        switch (Platform.fromString(properties.getPlatformName())) {
            case ANDROID:
                return new AndroidCapabilities(properties);
            case IOS:
                return new IOSCapabilities(properties);
            default:
                throw new IllegalStateException("Unexpected value: " + Platform.valueOf(properties.getPlatformName()));
        }
    }
}
