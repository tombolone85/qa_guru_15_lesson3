package com.demoqa;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

public class DemoQACheck extends TestBase{

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Test
    void pageFillIn(){
        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .genderClick(testData.gender)
                .setMobile(testData.mobile)
                .setBirthDate(testData.day,testData.month,testData.year)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.filePath)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit();

            registrationFormPage.modalTableIsVisible()
                    .checkTableContent("Student Name",testData.studentName)
                    .checkTableContent("Student Email",testData.email)
                    .checkTableContent("Gender", testData.gender)
                    .checkTableContent("Mobile",testData.mobile)
                    .checkTableContent("Date of Birth",testData.birthday)
                    .checkTableContent("Subjects",testData.subject)
                    .checkTableContent("Hobbies",testData.hobby)
                    .checkTableContent("Picture",testData.fileName)
                    .checkTableContent("Address",testData.address)
                    .checkTableContent("State and City",testData.stateAndCity);

    }
}
