package com.sample.framework.config;

import com.sample.framework.properties.Environment;
import org.openqa.selenium.MutableCapabilities;



public abstract class Capabilities {
    protected Environment environment;

    public Capabilities(Environment environment) {
        this.environment = environment;
    }

    public abstract MutableCapabilities getCapabilities();
}

