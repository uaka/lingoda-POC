package test.tests.student;

import models.Student;

import org.testng.annotations.Test;
import pages.student.CoursesPage;
import pages.student.PaymentPage;

import uitests.BaseTest;
import workflows.WorkFlow;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MakePayment  extends BaseTest {
    private Student student = new Student();

    @Test
    public void _01_registerStudentTest() {
        WorkFlow.register(student);
    }

    @Test
    public void _02_makePayment(){
        CoursesPage coursesPage = page(CoursesPage.class);
        PaymentPage paymentPage = page(PaymentPage.class);
        open("/en/english/courses/group/standard");
        coursesPage.selectLearningPlan(1);
        paymentPage.payByCard();
    }
}
