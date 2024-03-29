package com.sample.framework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.sample.framework.utils.WebElementUtils;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

public abstract class BaseScreen<T> extends WebElementUtils {
    protected Duration timeout = Duration.ofMillis(5000);

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public BaseScreen(AppiumDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public abstract T await();
}
