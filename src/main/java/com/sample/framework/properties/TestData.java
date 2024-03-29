package com.sample.framework.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

@Configuration
@PropertySource("classpath:testdata.properties")
public class TestData {
    @Value("${passcode}")
    String passcode;

    @Bean("passcode")
    public String getPasscode() {
        return passcode;
    }
}
