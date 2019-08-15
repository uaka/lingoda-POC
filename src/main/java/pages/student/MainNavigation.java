package pages.student;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Page;

import static com.codeborne.selenide.Selenide.$;

public class MainNavigation extends Page {
  public static SelenideElement container = $("ul[main-navigation=\"normal\"]");

}
