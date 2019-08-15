package pages.student;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CoursesPage extends Page {
  public static SelenideElement container = $("");
  ElementsCollection continueBtns = $$(By.xpath("//span[contains(text(), 'Continue')]"));

  public void selectLearningPlan(int index){
    continueBtns.get(index).click();
    webDriverWait.until(ExpectedConditions.urlContains("payment-summary"));

  }
}
