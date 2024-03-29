package com.sample.framework.config;

import com.sample.framework.properties.Environment;
import io.appium.java_client.proxy.NotImplementedException;
import org.openqa.selenium.MutableCapabilities;

public class IOSCapabilities extends Capabilities {

    public IOSCapabilities(Environment environment) {
        super(environment);
    }

    public MutableCapabilities getCapabilities() {
        throw new NotImplementedException();
    }
}
