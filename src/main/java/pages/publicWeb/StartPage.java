package pages.publicWeb;

import com.codeborne.selenide.SelenideElement;
import models.SectionsEnum;
import org.openqa.selenium.By;
import pages.Page;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class StartPage  extends Page {

    SelenideElement registrationBtn = $(By.xpath("//span[text()='Start Learning Now']"));

    public void openSection(SectionsEnum section){
        open("/en/" + section.getValue());
    }

    public void clickStartNow(){
        $(By.xpath("//*[text()='Start now']")).click();
    }

    //------- Registration form -------

public void registerNewUser(String email, String pass){
    registrationBtn.waitUntil(visible, conf.defaultTimeout());
    $("input[type='email']").setValue(email);
    $("input[type='password']").setValue(pass);
    $("input[name='marketing']").click();
    $("input[name='privacy']").click();
    registrationBtn.click();
}


}
