package com.sample.framework.utils;

import java.time.Duration;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.NoSuchElementException;

public abstract class WebElementUtils {
    protected static Duration defaultTimeout = Duration.ofMillis(2000);
    protected AppiumDriver driver;

    public boolean waitForWebElement(WebElement element, Duration timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        try {
            wait.until(driver -> element.isDisplayed());
            return true; // Element is displayed within the timeout
        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Element is not displayed within the timeout
        }
    }
}
