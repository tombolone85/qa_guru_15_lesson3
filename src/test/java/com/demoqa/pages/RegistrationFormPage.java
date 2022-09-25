package com.demoqa.pages;

import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ModalTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ModalTableComponent modalTableComponent = new ModalTableComponent();

    public RegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPage genderClick(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setMobile(String mobile) {
        $("#userNumber").setValue(mobile);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String filePath) {
        $("#uploadPicture").uploadFile(new File(filePath));
        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage modalTableIsVisible() {
        modalTableComponent.tableIsVisible();
        return this;
    }
    public RegistrationFormPage checkTableContent(String key, String value) {
        modalTableComponent.checkTableContent(key,value);
        return this;
    }
}