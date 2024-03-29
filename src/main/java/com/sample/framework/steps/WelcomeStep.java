package com.sample.framework.steps;

import com.sample.framework.screens.WelcomeScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class WelcomeStep {
    private AppiumDriver driver;
    public WelcomeStep(AppiumDriver driver) {
        this.driver = driver;
    }

    public WelcomeStep awaitPage() {
        new WelcomeScreen(driver).await();
        return this;
    }

    public WelcomeStep verifyUI() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        Assert.assertTrue(welcomeScreen.isGetStartedButtonDisplayed(),
                "Get Started Button not found in the Welcome Screen");
        Assert.assertTrue(welcomeScreen.isTermsConditionsDisplayed(),
                "Terms and condition not found in the Welcome Screen");

        return this;
    }
    public HomeStep navigateToHomeScreen() {
        new WelcomeScreen(driver).tapOnGetStarted();

        return new HomeStep(driver);
    }
}
