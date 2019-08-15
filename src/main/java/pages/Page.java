package pages;

import config.PropertiesConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Page {
    protected static PropertiesConfiguration conf = ConfigFactory.create(PropertiesConfiguration.class, System.getProperties());
    protected WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), 20);
}


