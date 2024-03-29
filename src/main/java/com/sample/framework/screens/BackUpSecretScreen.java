package com.sample.framework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class BackUpSecretScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"SKIP\")")
    private WebElement skipButton;
    @AndroidFindBy(uiAutomator = "text(\"Back up secret phrase\")")
    private WebElement backUpSecretPhraseTitle;
    @AndroidFindBy(uiAutomator = "text(\"Back up manually\")")
    private WebElement backUpManuallyButton;
    @AndroidFindBy(uiAutomator = "text(\"Back up to Google Drive\")")
    private WebElement backUpToGoogleDriveButton;

    public BackUpSecretScreen(AppiumDriver driver) {
        super(driver);
    }

    public BackUpSecretScreen await() {
        waitForWebElement(backUpSecretPhraseTitle, defaultTimeout);
        waitForWebElement(backUpManuallyButton, defaultTimeout);
        return this;
    }

    public boolean isSkipButtonDisplayed() {
        return skipButton.isDisplayed();
    }

    public boolean isBackupManuallyButtonDisplayed() {
        return backUpManuallyButton.isDisplayed();
    }

    public boolean isBackUpSecretPhraseTitleDisplayed() {
        return backUpSecretPhraseTitle.isDisplayed();
    }

    public boolean isBackupToGoogleDriverButtonDisplayed() {
        return backUpToGoogleDriveButton.isDisplayed();
    }

    public SecretPhraseCheckScreen tapOnBackupManuallyButton() {
        backUpManuallyButton.click();
        return new SecretPhraseCheckScreen(driver, timeout);
    }
}
