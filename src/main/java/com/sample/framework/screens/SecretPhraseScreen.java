package com.sample.framework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecretPhraseScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '1.')]/parent::android.view.View//android.widget.TextView")
    private List<WebElement> secretPhraseTexts;
    @AndroidFindBy(uiAutomator = "text(\"Secret phrase\")")
    private WebElement secretPhraseTitle;
    @AndroidFindBy(uiAutomator = "text(\"Continue\")")
    private WebElement continueButton;
    @AndroidFindBy(uiAutomator = "text(\"Copy to Clipboard\")")
    private WebElement copyToClipBoardButton;



    public boolean isSecretPhraseTitleDisplayed() {
        return secretPhraseTitle.isDisplayed();
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }

    public boolean isCopyToClipBoardButtonDisplayed() {
        return copyToClipBoardButton.isDisplayed();
    }

    public SecretPhraseScreen(AppiumDriver driver) {
        super(driver);
    }

    public SecretPhraseScreen await() {
        waitForWebElement(secretPhraseTitle, defaultTimeout);
        waitForWebElement(copyToClipBoardButton, defaultTimeout);
        return this;
    }

    public Map<Integer, String> getSecretPhrases() {
//        Map of Option Index and Option
//        example: {1=alcohol, 2=tobacco, 3=become, 7=romance, 8=cart}

        return secretPhraseTexts
                .stream()
                .map(WebElement::getText)
                .map(s -> s.split("\\. ", 2))
                .collect(Collectors.toMap(arr -> Integer.parseInt(arr[0]), arr -> arr[1],                 (a, b) -> b));
    }

    public ConfirmSecretPhraseScreen clickContinue() {
        continueButton.click();
        return new ConfirmSecretPhraseScreen(driver);
    }
}
