package core.driver;

import com.codeborne.selenide.WebDriverRunner;

import config.PropertiesConfiguration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class WebDriverFactory {
    private static Logger logger = Logger.getLogger(WebDriverFactory.class);
    public static final String USERNAME = "lingoda";
    public static final String AUTOMATE_KEY = "sV9JMwMDgdouvwPzzzDY";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    String sessionId;

    public static void createDriver() {
        PropertiesConfiguration conf = ConfigFactory.create(PropertiesConfiguration.class, System.getProperties());

        logger.info(String.format("Starting driver for platform %s", conf.platform()));
        switch (conf.platform().toLowerCase()) {
            case "local":
            //    ChromeDriverManager.getInstance().setup();
                logger.info("Starting local driver");
                WebDriverRunner.setWebDriver(new ChromeDriver());

                break;
            case "browserstack":

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "62.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");
              //  caps.setCapability("name", "Bstack-[Java] Sample Test");

                RemoteWebDriver  driver = null;
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                String sessionId = driver.getSessionId().toString();
                logger.info("RemoteWebDriver on browserstack started. sessionId="+sessionId);
                WebDriverRunner.setWebDriver(driver);
                break;
        }
    }


}

