package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void configuration() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize="5760x3240";
        Configuration.holdBrowserOpen=true;
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
