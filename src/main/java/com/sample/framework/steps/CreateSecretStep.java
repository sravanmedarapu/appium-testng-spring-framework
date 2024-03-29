package com.sample.framework.steps;

import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.sample.framework.properties.TestData;
import com.sample.framework.screens.CreatePassCodeScreen;
import com.sample.framework.screens.SecretPhraseScreen;

import java.util.Map;

@Component
public class CreateSecretStep {

    @Autowired
    TestData testData;

    private AppiumDriver driver;
    private SecretPhraseScreen secretPhraseScreen;
    public CreateSecretStep(AppiumDriver driver) {
        this.driver = driver;
    }

    public CreateSecretStep awaitPage() {
        secretPhraseScreen = new SecretPhraseScreen(driver);
        secretPhraseScreen.await();

        return this;
    }

    public CreateSecretStep verifySelectSecretPhraseUI() {
        String errorMSGPostFix = "not found in the Backup Screen";
        Assert.assertTrue(secretPhraseScreen.isSecretPhraseTitleDisplayed(),
                "Backup Secret phrase Title" + errorMSGPostFix);
        Assert.assertTrue(secretPhraseScreen.isContinueButtonDisplayed(),
                "Continue Button" + errorMSGPostFix);
        Assert.assertTrue(secretPhraseScreen.isCopyToClipBoardButtonDisplayed(),
                "Copy to clipboard Button" + errorMSGPostFix);

        return this;
    }

    public CreateSecretStep completeSecretPhrase() {
        Map<Integer, String> secretsMapWithNumberAsKey =  secretPhraseScreen.getSecretPhrases();
        secretPhraseScreen
                .clickContinue()
                .await()
                .confirmSecretPhrases(secretsMapWithNumberAsKey)
                .tapOnContinue();
        return this;
    }

    public void setupPasscode(String passcode) {
        new CreatePassCodeScreen(driver)
                .await()
                .setPassCode(passcode)
                .confirmPassCode(passcode);


    }


}
