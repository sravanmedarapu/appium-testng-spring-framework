package com.sample.framework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WelcomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Get Started\")")
    private WebElement getStartedButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"By tapping “Get Started” you agree and consent to our \n" +
            "Terms of Service and Privacy Policy\"]")
    private WebElement termConditionFooter;


    public WelcomeScreen(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public WelcomeScreen await() {
        waitForWebElement(getStartedButton, timeout);
        return null;
    }

    public CreateWalletScreen tapOnGetStarted() {
        getStartedButton.click();
        return new CreateWalletScreen(driver);
    }

    public boolean isGetStartedButtonDisplayed() {
        return getStartedButton.isDisplayed();
    }

    public boolean isTermsConditionsDisplayed() {
        return termConditionFooter.isDisplayed();
    }
}

