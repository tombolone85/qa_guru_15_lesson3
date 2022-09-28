package com.demoqa;

import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;

public class TestData {
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
}
