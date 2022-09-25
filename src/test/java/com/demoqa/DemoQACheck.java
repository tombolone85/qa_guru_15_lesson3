package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoQACheck {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
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
    }

    @BeforeEach
    void pageFillIn(){
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .genderClick("Male")
                .setMobile(mobile)
                .setBirthDate("28","July","1985")
                .setSubjects("Physics")
                .setHobbies("Reading")
                .uploadPicture("src/test/resources/5.png")
                .setAddress(address)
                .setState("Haryana")
                .setCity("Panipat")
                .clickSubmit();
    }
    @Test
    void tableCheck(){
        registrationFormPage.modalTableIsVisible();
        registrationFormPage.checkTableContent("Student Name",studentName);
        registrationFormPage.checkTableContent("Student Email",email);
        registrationFormPage.checkTableContent("Gender","Male");
        registrationFormPage.checkTableContent("Mobile",mobile);
        registrationFormPage.checkTableContent("Date of Birth","28 July,1985");
        registrationFormPage.checkTableContent("Subjects","Physics");
        registrationFormPage.checkTableContent("Hobbies","Reading");
        registrationFormPage.checkTableContent("Picture","5.png");
        registrationFormPage.checkTableContent("Address",address);
        registrationFormPage.checkTableContent("State and City","Haryana Panipat");
    }
}
