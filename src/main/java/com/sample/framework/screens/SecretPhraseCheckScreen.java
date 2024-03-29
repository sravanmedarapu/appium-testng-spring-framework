package com.sample.framework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SecretPhraseCheckScreen extends BaseScreen {

    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> textElements;
    @AndroidFindBy(uiAutomator = "text(\"This secret phrase is the master key to your wallet\")")
    private WebElement pageID;
    @AndroidFindBy(uiAutomator = "text(\"Continue\")")
    private WebElement continueButtonElement;

    @AndroidFindBy(uiAutomator = "text(\"Trust Wallet does not keep a copy of your secret phrase.\")")
    private WebElement dataCheckBox;

    @AndroidFindBy(uiAutomator = "text(\"Saving this digitally in plain text is NOT recommended. Examples include screenshots, text files, or emailing yourself\")")
    private WebElement notRecommendedCheckBox;

    @AndroidFindBy(uiAutomator = "text(\"Write down your secret phrase, and store it in a secure offline location!\")")
    private WebElement storeOfflineCheckBox;


    public SecretPhraseCheckScreen(AppiumDriver driver, Duration timeout) {
        super(driver, timeout);
    }

    public SecretPhraseCheckScreen await() {
        waitForWebElement(pageID, defaultTimeout);
        waitForWebElement(continueButtonElement, defaultTimeout);
        return this;
    }

    public SecretPhraseCheckScreen checkAllCheckbox() {
        storeOfflineCheckBox.click();
        dataCheckBox.click();
        notRecommendedCheckBox.click();
        return this;
    }

    public SecretPhraseScreen clickContinue() {
        continueButtonElement.click();
        return new SecretPhraseScreen(driver);
    }
}
