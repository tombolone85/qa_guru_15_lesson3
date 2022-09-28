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
    String gender = "Male";
    String day = "28";
    String month = "July";
    String year = "1985";
    String subject = "Physics";
    String hobby = "Reading";
    String filePath = "src/test/resources/5.png";
    String state = "Haryana";
    String city = "Panipat";
    String fileName = "5.png";
    String birthday = "28 July,1985";
    String stateAndCity = "Haryana Panipat";

    @BeforeAll
    public static void сonfiguration() {
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen=true;
    }

    @BeforeEach
    void pageFillIn(){
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .genderClick(gender)
                .setMobile(mobile)
                .setBirthDate(day,month,year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(filePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();
    }
    @Test
    void tableCheck(){
        registrationFormPage.modalTableIsVisible()
            .checkTableContent("Student Name",studentName)
        .checkTableContent("Student Email",email)
        .checkTableContent("Gender", gender)
        .checkTableContent("Mobile",mobile)
        .checkTableContent("Date of Birth",birthday)
        .checkTableContent("Subjects",subject)
        .checkTableContent("Hobbies",hobby)
        .checkTableContent("Picture",fileName)
        .checkTableContent("Address",address)
        .checkTableContent("State and City",stateAndCity);
    }
}
