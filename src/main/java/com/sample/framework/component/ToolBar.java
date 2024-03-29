package com.sample.framework.component;

import com.sample.framework.utils.WebElementUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ToolBar extends WebElementUtils {
    @AndroidFindBy(uiAutomator = "text(\"Home\")")
    private WebElement home;
    @AndroidFindBy(uiAutomator = "text(\"Swap\")")
    private WebElement swap;
    @AndroidFindBy(uiAutomator = "text(\"Earn\")")
    private WebElement earn;
    @AndroidFindBy(uiAutomator = "text(\"Discover\")")
    private WebElement discover;
    @AndroidFindBy(uiAutomator = "text(\"Browser\")")
    private WebElement browser;


    public ToolBar(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isHomeTabDisplayed() {
        return home.isDisplayed();
    }

    public boolean isSwapTabDisplayed() {
        return swap.isDisplayed();
    }

    public boolean isEarnTabDisplayed() {
        return earn.isDisplayed();
    }

    public boolean isDiscoverTabDisplayed() {
        return discover.isDisplayed();
    }

    public boolean isBrowserTabDisplayed() {
        return browser.isDisplayed();
    }
}
