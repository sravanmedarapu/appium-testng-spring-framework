package com.sample.framework.config;

import com.sample.framework.properties.Environment;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;

import java.time.Duration;

public class AndroidCapabilities extends Capabilities {

    public AndroidCapabilities(Environment environment) {
        super(environment);
    }

    public MutableCapabilities getCapabilities() {
        return new UiAutomator2Options().setNewCommandTimeout(Duration.ZERO)
                .setDeviceName(environment.getDeviceName())
                .setPlatformVersion(environment.getPlatformVersion())
                .setPlatformName(environment.getPlatformName())
                .setAppActivity(environment.getAppActivity())
                .setAppPackage(environment.getAppPackage())
                .setApp(environment.getApp())
                .autoGrantPermissions()
                .setFullReset(environment.fullReset())
                .setNoReset(false)
                .setAllowTestPackages(true)
                .setAppWaitPackage(environment.getAppPackage());
    }
}
