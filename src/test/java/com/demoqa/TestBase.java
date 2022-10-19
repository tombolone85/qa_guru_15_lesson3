package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void configuration() {
        Configuration.browserSize="5760x3240";
        Configuration.holdBrowserOpen=true;
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
