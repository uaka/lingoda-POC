package workflows;

import com.codeborne.selenide.Condition;
import config.PropertiesConfiguration;
import models.SectionsEnum;
import models.Student;
import org.aeonbits.owner.ConfigFactory;
import pages.publicWeb.StartPage;
import pages.student.MainNavigation;

import static com.codeborne.selenide.Selenide.page;

public class WorkFlow {
    protected static PropertiesConfiguration conf = ConfigFactory.create(PropertiesConfiguration.class, System.getProperties());
    public static void register(Student student){
        StartPage startPage = page(StartPage.class);
        startPage.openSection(SectionsEnum.ENGLISH);
        startPage.clickStartNow();
        startPage.registerNewUser(student.getEmail(), student.getPassword());
        MainNavigation.container.waitUntil(Condition.visible, conf.longTimeout());
    }
}
