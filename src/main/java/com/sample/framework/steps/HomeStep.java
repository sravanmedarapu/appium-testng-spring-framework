package com.sample.framework.steps;

import com.sample.framework.component.ToolBar;
import com.sample.framework.screens.CreateWalletScreen;
import com.sample.framework.screens.HomePage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class HomeStep {
    private AppiumDriver driver;

    private ToolBar toolBar;
    private HomePage homePage;
    public HomeStep(AppiumDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        toolBar = new ToolBar(driver);
    }

    public HomeStep awaitPage() {
        new CreateWalletScreen(driver).await();
        return this;
    }

    public CreateWalletStep createNewWallet() {
        new CreateWalletScreen(driver)
                .tapOnCreateNewWallet();

        return new CreateWalletStep(driver);
    }

    public HomeStep verifyToolBar() {
        Assert.assertTrue(toolBar.isHomeTabDisplayed(),
                "Home not found in the Tool Bar");
        Assert.assertTrue(toolBar.isEarnTabDisplayed(),
                "Earn not found in the Tool Bar");
        Assert.assertTrue(toolBar.isDiscoverTabDisplayed(),
                "Discover not found in the Tool Bar");
        Assert.assertTrue(toolBar.isSwapTabDisplayed(),
                "Swap not found in the Tool Bar");
        Assert.assertTrue(toolBar.isBrowserTabDisplayed(),
                "Browser not found in the Tool Bar");

        return this;
    }

    public HomeStep verifyHomeScreenUI() {
        Assert.assertTrue(homePage.isWelcomeAboardPopupDisplayed(),
                "Welcome Aboard popup not found");
        Assert.assertTrue(homePage.isStartUsingTrustWalletButtonDisplayed(),
                "Start using Trust Wallet Button not found");

        return this;
    }

    public HomeStep closeStartUsingTrustWalletPopup() {
        homePage.tapOnStartUsingTrustWalletButton();
        return this;
    }



}
