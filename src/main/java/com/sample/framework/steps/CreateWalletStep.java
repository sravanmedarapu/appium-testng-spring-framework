package com.sample.framework.steps;

import com.sample.framework.screens.BackUpSecretScreen;
import com.sample.framework.screens.CreateNewWalletScreen;
import com.sample.framework.screens.SecretPhraseScreen;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class CreateWalletStep {
    private AppiumDriver driver;
    private CreateNewWalletScreen createNewWalletScreen;
    private BackUpSecretScreen backUpSecretScreen;
    private SecretPhraseScreen secretPhraseScreen;
    public CreateWalletStep(AppiumDriver driver) {
        this.driver = driver;
    }

    public CreateWalletStep awaitPage() {
        createNewWalletScreen = new CreateNewWalletScreen(driver);
        createNewWalletScreen.await();

        return this;
    }

    public CreateWalletStep verifyCreateWalletScreenUI() {
        String errorMSGPostFix = "not found in the CreateNewWallet Screen";
        Assert.assertTrue(createNewWalletScreen.isCreateNewWalletHeaderDisplayed(),
                "Create New Wallet Title" + errorMSGPostFix);
        Assert.assertTrue(createNewWalletScreen.isCreateSecretPhraseButtonDisplayed(),
                "Create Secret Phrase Button" + errorMSGPostFix);
        Assert.assertTrue(createNewWalletScreen.isSecretPhraseOptionDisplayed(),
                "Create Secret Phrase option" + errorMSGPostFix);

        return this;
    }


    public CreateWalletStep creteSecretePhrase() {
        backUpSecretScreen = createNewWalletScreen
                .clickOnCreateSecretPhrase();
        backUpSecretScreen.await();
        return this;
    }

    public CreateWalletStep verifyBackUpScreenUI() {
        String errorMSGPostFix = "not found in the Backup Screen";
        Assert.assertTrue(backUpSecretScreen.isBackUpSecretPhraseTitleDisplayed(),
                "Backup Secret phrase Title" + errorMSGPostFix);
        Assert.assertTrue(backUpSecretScreen.isBackupManuallyButtonDisplayed(),
                "Backup manually Button" + errorMSGPostFix);
        Assert.assertTrue(backUpSecretScreen.isBackupToGoogleDriverButtonDisplayed(),
                "Backup to Google Driver Button" + errorMSGPostFix);
        Assert.assertTrue(backUpSecretScreen.isSkipButtonDisplayed(),
                "Skip Button" + errorMSGPostFix);

        return this;
    }

    public CreateSecretStep createSecretWithManualBackUp() {
        secretPhraseScreen = backUpSecretScreen
                .tapOnBackupManuallyButton()
                .await()
                .checkAllCheckbox()
                .clickContinue();

        return new CreateSecretStep(driver);
    }








}
