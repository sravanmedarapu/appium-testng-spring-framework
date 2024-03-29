package com.sample.framework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CreateNewWalletScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Secret phrase']")
    private WebElement secretPhrase;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Secret phrase']/following-sibling::android.view.View/android.widget.TextView[@text='Create']")
    private WebElement createSecretPhraseButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create new wallet']")
    private WebElement createNewWalletHeader;

    public boolean isSecretPhraseOptionDisplayed() {
        return secretPhrase.isDisplayed();
    }

    public boolean isCreateSecretPhraseButtonDisplayed() {
        return createSecretPhraseButton.isDisplayed();
    }

    public boolean isCreateNewWalletHeaderDisplayed() {
        return createNewWalletHeader.isDisplayed();
    }

    public CreateNewWalletScreen(AppiumDriver driver) {
        super(driver);
    }

    public CreateNewWalletScreen await() {
        waitForWebElement(createNewWalletHeader, defaultTimeout);
        waitForWebElement(secretPhrase, defaultTimeout);
        return this;
    }

    public BackUpSecretScreen clickOnCreateSecretPhrase() {
        createSecretPhraseButton.click();
        return new BackUpSecretScreen(driver);
    }
}
