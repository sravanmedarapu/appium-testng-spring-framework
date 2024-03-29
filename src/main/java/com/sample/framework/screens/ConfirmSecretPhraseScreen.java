package com.sample.framework.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

public class ConfirmSecretPhraseScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Confirm secret phrase\")")
    private WebElement pageID;
    @AndroidFindBy(uiAutomator = "text(\"Confirm\")")
    private WebElement confirmButtonElement;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Word #\")")
    private List<WebElement> expectedWordHeaderElement;

//    Xpath to get all secret phrase options(TextView) in the grid
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please tap on the correct answer of the below seed phrases.']/following-sibling::android.view.View[1]//android.widget.TextView")
    private List<WebElement> secretWordChoiceGrid;


    public ConfirmSecretPhraseScreen(AppiumDriver driver) {
        super(driver);
    }

    public ConfirmSecretPhraseScreen await() {
        waitForWebElement(pageID, defaultTimeout);
        return this;
    }

    public ConfirmSecretPhraseScreen confirmSecretPhrases(Map<Integer, String> secretsMapWithNumberAsKey) {


        Map<Integer, List<String>> optionsMap = new LinkedHashMap<>();
        /**
         * 1: [tobacco, become, alcohol]
         * 4: [raccoon, claim, risk]
         * 7: [romance, cart, inner]
         * 10: [void, visual, item]
         */
        List<String> options = null;

        List<String> gridOptions = secretWordChoiceGrid.stream().map(WebElement::getText).collect(Collectors.toList());
        for (String option : gridOptions) {
            if (option.startsWith("Word #")) {
                options = new ArrayList<>();
                Integer wordIndex = Integer.parseInt(option.split("#")[1].trim());
                optionsMap.put(wordIndex, options);
            } else {
                options.add(option);
            }
        }

        optionsMap.forEach((wordIndex, wordOptions) -> {
            String rightAnswer = secretsMapWithNumberAsKey.get(wordIndex);

            String optionIndex = "Word #"+ wordIndex;
            String xpath = "//android.widget.TextView[@text='" + optionIndex + "']/following-sibling::android.view.View/android.widget.TextView[@text='" + rightAnswer + "']" ;
            driver.findElement(AppiumBy.xpath(xpath)).click();
        });

        return this;
    }

    public CreatePassCodeScreen tapOnContinue() {
        confirmButtonElement.click();
        return new CreatePassCodeScreen(driver);
    }
}
