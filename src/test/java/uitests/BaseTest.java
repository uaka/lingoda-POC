package uitests;

import com.codeborne.selenide.Configuration;
import config.PropertiesConfiguration;
import core.driver.WebDriverFactory;
import helper.OSValidator;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    private static Logger logger = Logger.getLogger(WebDriverFactory.class);
    protected static PropertiesConfiguration conf = ConfigFactory.create(PropertiesConfiguration.class, System.getProperties());
    WebDriverFactory webDriverFactory;
    WebDriver driver;
    @BeforeTest
    public void setup() throws URISyntaxException {

        webDriverFactory.createDriver();
        URL resource = null;
        if (OSValidator.isWindows())
            resource = BaseTest.class.getResource("/chromedriver.exe");
        else if (OSValidator.isMac())
            resource = BaseTest.class.getResource("/chromedriver_MAC");
        else if (OSValidator.isUnix())
            resource = BaseTest.class.getResource("/chromedriver_linux");

        String chromedriverPath = Paths.get(resource.toURI()).toFile().getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        System.setProperty("selenide.browser", "Chrome");
        Configuration.browser = "chrome";
        Configuration.timeout = conf.defaultTimeout();
        Configuration.baseUrl = conf.url(conf.id()).getText();
        open("/");
    }

    @AfterTest
    public void tearDown(){
        logger.info("Quit " + getWebDriver().getTitle());
        getWebDriver().quit();
    }
}
