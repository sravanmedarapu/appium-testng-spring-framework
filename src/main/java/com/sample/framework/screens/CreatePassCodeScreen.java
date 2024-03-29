package com.sample.framework.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CreatePassCodeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Create passcode\")")
    private WebElement pageID;

    public CreatePassCodeScreen(AppiumDriver driver) {
        super(driver);
    }

    public CreatePassCodeScreen await() {
        waitForWebElement(pageID, Duration.ofMillis(10000));
        return this;
    }

    public ConfirmPassCodeScreen setPassCode(String passcode) {
        for (char ch : passcode.toCharArray()) {
            WebElement element = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + String.valueOf(ch) + "\")"));
            waitForWebElement(element, defaultTimeout);
            element.click();
        }
        return new ConfirmPassCodeScreen(driver);
    }
}

