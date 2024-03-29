package com.sample.framework.config;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.MutableCapabilities;

import java.io.IOException;

public interface IDriver {

    AppiumDriver setUpDriver(MutableCapabilities capabilities) throws Exception;

    void tearDownDriver() throws Exception;
}