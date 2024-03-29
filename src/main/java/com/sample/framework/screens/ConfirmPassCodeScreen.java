package com.sample.framework.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ConfirmPassCodeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Confirm passcode\")")
    private WebElement pageID;

    public ConfirmPassCodeScreen(AppiumDriver driver) {
        super(driver);
    }


    public ConfirmPassCodeScreen await() {
        waitForWebElement(pageID, Duration.ofMillis(10000));
        return this;
    }

    public CreateWalletScreen confirmPassCode(String passcode) {
        for (char ch : passcode.toCharArray()) {
            WebElement element = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + String.valueOf(ch) + "\")"));
            waitForWebElement(element, defaultTimeout);
            element.click();
        }
        return new CreateWalletScreen(driver);
    }
}

