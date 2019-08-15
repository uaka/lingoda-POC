package core.driver;

import com.codeborne.selenide.WebDriverRunner;
import config.PropertiesConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class WebDriverFactory {
    private static Logger logger = Logger.getLogger(WebDriverFactory.class);

    public static void createDriver() {
        PropertiesConfiguration conf = ConfigFactory.create(PropertiesConfiguration.class, System.getProperties());
        String URL = "https://" + conf.browserstackUser() + ":" + conf.browserstackKey() + "@hub-cloud.browserstack.com/wd/hub";
        logger.info(String.format("Starting driver for %s env", conf.platform()));

        switch (conf.platform().toLowerCase()) {
            case "local":
                //    ChromeDriverManager.getInstance().setup();
                logger.info("Starting local driver");
                WebDriverRunner.setWebDriver(new ChromeDriver());
                break;

            case "browserstack":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", conf.browser());
                caps.setCapability("browser_version", conf.browser_version());
                caps.setCapability("os", conf.os());
                caps.setCapability("os_version", conf.os_version());
                caps.setCapability("resolution", "1024x768");
                caps.setCapability("name", "BrowserStack Lingoda autotests");
                RemoteWebDriver driver = null;

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                String sessionId = driver.getSessionId().toString();
                logger.info("RemoteWebDriver on browserstack started. sessionId = " + sessionId);
                WebDriverRunner.setWebDriver(driver);
                break;
        }
    }
}

