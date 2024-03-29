package com.sample.framework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseScreen {
    @AndroidFindBy(uiAutomator = "text(\"Welcome aboard\")")
    private WebElement welcomeAboardPopup;

    @AndroidFindBy(uiAutomator = "text(\"Start using Trust Wallet\")")
    private WebElement startUsingTrustWalletButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage await() {
        waitForWebElement(welcomeAboardPopup, timeout);
        waitForWebElement(startUsingTrustWalletButton, timeout);
        return this;
    }

    public void tapOnStartUsingTrustWalletButton() {
        startUsingTrustWalletButton.click();
    }

    public Boolean isWelcomeAboardPopupDisplayed() {
        return welcomeAboardPopup.isDisplayed();
    }

    public Boolean isStartUsingTrustWalletButtonDisplayed() {
        return startUsingTrustWalletButton.isDisplayed();
    }
}
