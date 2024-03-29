package tests.com.sample.test;

import com.sample.framework.steps.CreateSecretStep;
import com.sample.framework.steps.CreateWalletStep;
import com.sample.framework.steps.HomeStep;
import com.sample.framework.steps.WelcomeStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.sample.framework.properties.TestData;
import com.sample.framework.utils.AUT;


@Component
public class BaseTest extends AUT {
    public WelcomeStep welcomeScreenStep;
    public HomeStep homeScreenStep;
    public CreateWalletStep createWalletStep;
    public CreateSecretStep createSecretStep;

    @Autowired
    TestData testData;

    @BeforeMethod
    public void setUp() throws Exception {
        startAppiumServer();
        setUpDriver(getCapabilities());
        initSteps();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        tearDownDriver();
        stopAppiumServer();
    }


    private void initSteps() {
        welcomeScreenStep = new WelcomeStep(driver);
        homeScreenStep = new HomeStep(driver);
        createWalletStep = new CreateWalletStep(driver);
        createSecretStep = new CreateSecretStep(driver);
    }
}
