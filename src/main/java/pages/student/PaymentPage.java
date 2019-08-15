package pages.student;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Page;

import static com.codeborne.selenide.Selenide.*;

public class PaymentPage extends Page {
    public static SelenideElement termsLink = $("input[name=\"termsAndConditions\"]");
    public static SelenideElement privacyLink = $("#privacy");

    public static SelenideElement paymentMethodTitle = $(By.xpath("//h3[contains(text(),'Payment method')]"));
    public static SelenideElement paymentMethodVisa = $("input[name=\"payment-method\"][value=\"creditCards\"]");
    public static SelenideElement paymentMethodSofort = $("input[name=\"payment-method\"][value=\"sofort\"]");
    public static SelenideElement sofortNameFld = $(By.xpath("//label[contains(text(),\"Name\")]//parent::div[1]//input"));
    public static SelenideElement sofortCountrySelect = $(By.xpath("//label[contains(text(),\"Country\")]/parent::div[1]//div[@role=\"button\"]"));
    public static SelenideElement sofortCountry = $(By.xpath("//div[@role=\"document\"]//ul//li[@data-value=\"${country}\"]"));
    public static SelenideElement sofortAuthorizeTestPaymentButton = $(By.xpath("//button[contains(text(),'Authorize Test Payment')]"));
    public static SelenideElement sofortFailTestPaymentButton = $(By.xpath("//button[contains(text(),'Fail Test Payment')]"));

    public static SelenideElement stripeFrame = $("iframe[name*=\"__privateStripeFrame\"]");
    public static SelenideElement cardFieldStripe = $("input[name=\"cardnumber\"][placeholder=\"Card number\"]");
    public static SelenideElement dateFieldStripe = $("input[name=\"exp-date\"][placeholder=\"MM / YY\"]");
    public static SelenideElement CVCFieldStripe = $("input[name=\"cvc\"][placeholder=\"CVC\"]");
    public static SelenideElement ZIPFieldStripe = $("input[name=\"postal\"][placeholder=\"ZIP\"]");
    public static SelenideElement confirmPaymentStripe = $(By.xpath("//button[@type=\"submit\"][@tabindex=\"0\"]"));
    public static SelenideElement confirmPrivacyStripeOrphanNonRegistered = $("input[name=\"privacy\"]");
    public static SelenideElement addPaymentMethodButton = $(By.xpath("//span[contains(text(),'Add payment method')]"));

    public static SelenideElement promoCodeTitle = $(By.xpath("//p[contains(text(),'Promo code discount')]"));
    public static SelenideElement processingPayment = $(By.xpath("//h1[contains(text(),'Processing payment')]"));

    public void payByCard() {
        termsLink.shouldBe(Condition.exist);
        termsLink.shouldBe(Condition.enabled);
        termsLink.click();
        switchTo().frame(stripeFrame);
        cardFieldStripe.shouldBe(Condition.enabled);
        cardFieldStripe.sendKeys("4242 4242 4242 4242");
        dateFieldStripe.setValue("1022");
        CVCFieldStripe.setValue("737");
        CVCFieldStripe.shouldHave(Condition.value("737"));
        ZIPFieldStripe.shouldBe(Condition.enabled);
        ZIPFieldStripe.setValue("11111");
        switchTo().defaultContent();
        confirmPaymentStripe.click();
        webDriverWait.until(ExpectedConditions.urlContains("payment-pending"));
    }
}
