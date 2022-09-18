package com.demoqa;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQACheck {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String mobile = faker.numerify("##########");
    String studentName = (firstName + " " + lastName);
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String file = faker.internet().image();
    @BeforeAll
    public static void Configuration() {
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen=true;
        open("https://demoqa.com/automation-practice-form");
    }

    @BeforeEach
    void pageFillIn(){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $( byText("Male")).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1985");
        $("div[aria-label='Choose Sunday, July 21st, 1985']").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/5.png"));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();
    }
    @Test
    void tableCheck(){
//        $("tbody tr:nth-child(1) td:nth-child(2)").shouldBe(Condition.visible);
        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(Condition.text(studentName));
        $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(Condition.text(email));
        $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(Condition.text("Male"));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(Condition.text(mobile));
        $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(Condition.text("21 July,1985"));
        $("tbody tr:nth-child(6) td:nth-child(2)").shouldHave(Condition.text("Physics"));
        $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(Condition.text("Reading"));
        $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(Condition.text("5.png"));
        $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(Condition.text(address));
        $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(Condition.text("Haryana Panipat"));

    }
}
