package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

import static io.qameta.allure.internal.shadowed.jackson.databind.type.LogicalType.Map;
import static java.lang.constant.ClassDesc.of;

public class TestBase {
    @BeforeAll
    public static void configuration() {


        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName","chrome");
//        capabilities.setCapability("browserVersion","100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo",true);
        
        Configuration.browserCapabilities =capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize="5760x3240";
        Configuration.holdBrowserOpen=true;
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }

}
