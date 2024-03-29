package tests.com.sample.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import com.sample.framework.properties.Environment;
import com.sample.framework.properties.TestData;

import java.lang.reflect.Method;


@SpringBootTest
@ContextConfiguration(classes = {CreateWalletTest.class, Environment.class, TestData.class})
public class CreateWalletTest extends BaseTest {
    @Test
    public void failingTest(Method method) {
       //        Navigate to Landing Screen
        homeScreenStep = welcomeScreenStep
                .awaitPage()
                .verifyUI()
                .navigateToHomeScreen()
                .closeStartUsingTrustWalletPopup();
    }

        @Test
    public void createWallet(Method method) {
//        Navigate to Landing Screen
        homeScreenStep = welcomeScreenStep
                .awaitPage()
                .verifyUI()
                .navigateToHomeScreen();

//        Navigate to Create New Wallet
        createWalletStep = homeScreenStep
                .awaitPage()
                .verifyToolBar()
                .createNewWallet();

//        Create Secret Phrase with manual back up option
        createSecretStep = createWalletStep
                .awaitPage()
                .verifyCreateWalletScreenUI()
                .creteSecretePhrase()
                .verifyBackUpScreenUI()
                .createSecretWithManualBackUp();


//        Set Secret Phrase and set passcode
        createSecretStep
                .awaitPage()
                .verifySelectSecretPhraseUI()
                .completeSecretPhrase()
                .setupPasscode(testData.getPasscode());

//        validate home screen after successful wallet creation
        homeScreenStep
                .verifyHomeScreenUI()
                .closeStartUsingTrustWalletPopup()
                .verifyToolBar();
    }
}
