package com.sample.framework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CreateWalletScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "text(\"Create new wallet\")")
    private WebElement createNewWalletElement;
    @AndroidFindBy(uiAutomator = "text(\"Add existing wallet\")")
    private WebElement addExistingWalletElement;


    public CreateWalletScreen(AppiumDriver driver) {
        super(driver);
    }

    public CreateWalletScreen await() {
        waitForWebElement(createNewWalletElement, Duration.ofMillis(5000));
        return this;
    }

    public BackUpSecretScreen tapOnCreateNewWallet() {
        createNewWalletElement.click();

        return new BackUpSecretScreen(driver);
    }
}
