package com.sample.framework.utils;

import com.sample.framework.properties.Environment;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class AppiumService {

    private static final Logger logger = LoggerFactory.getLogger(AppiumService.class);

    private Environment environment;

    public AppiumService(Environment environment) {
        this.environment = environment;
    }

    private AppiumDriverLocalService server;

    public void startAppiumServer() throws IOException {
        logger.debug("Starting the Appium server");
        if (server == null || !server.isRunning()) {
            AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
            serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "info"); // Set log level to info
            serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            serviceBuilder.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/");
            serviceBuilder.withIPAddress("127.0.0.1");
            serviceBuilder.usingAnyFreePort();
            serviceBuilder.withLogFile(getLogFile(environment.getAppiumLog()));
            server = AppiumDriverLocalService.buildService(serviceBuilder);
            server.start();
            logger.debug("Finished starting the Appium server");
        } else {
            logger.warn("The Appium server is already running");
        }
    }

    private File getLogFile(String appiumLog) throws IOException {
        File logFile =  new File(System.getProperty("user.dir") + appiumLog);
        FileUtils.touch(logFile);
        return logFile;
    }

    public void stopService() {
        logger.debug("Stop the Appium server");
        server.stop();
        logger.debug("Finished stopping the Appium server");
    }

    public URL getServerUrl() throws IOException {
        if (server == null || !server.isRunning()) {
            startAppiumServer();
        }

        URL url = server.getUrl();
        logger.debug("The Appium server URL is: " + url.toString());
        return url;
    }
}
