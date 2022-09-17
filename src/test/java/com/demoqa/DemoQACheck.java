package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class DemoQACheck {
    @BeforeAll
    public static void Configuration() {
        Configuration.browserSize="6400x4800";
        Configuration.holdBrowserOpen=true;
    }
    Faker faker = new Faker();
    Random random = new Random();


    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String mobile = faker.numerify("##########");
    String studentName = (firstName + " " + lastName);


    @Test
    void pageCheck(){
        open("https://demoqa.com/automation-practice-form");
        $x("//input[@id='firstName']").setValue(firstName);
        $x("//input[@id='lastName']").setValue(lastName);
        $x("//label[@for='gender-radio-1']").click();
        $x("//input[@id='userNumber']").setValue(mobile);
        $x("//button[@id='submit']").click();
        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(Condition.text(firstName+" "+lastName));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(Condition.text(mobile));


    }
}
