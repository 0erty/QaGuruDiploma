package com.quadcode.tests.ui;

import com.quadcode.pages.MainPage;
import com.quadcode.tests.TestBase;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Story("Login tests")
public class RequestTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Tag("QuadCode")
    @DisplayName("Successful request sent from the main page Quadcode (UI)")
    void requestSentTest() {
        step("Open login page", () ->
                open("https://quadcode.com/"));

        step("Check Main Page", () -> {
            mainPage.checkWelcomeInner();
        });

        step("Open request modal", () -> {
            mainPage.clickContactBtn()
                    .checkRequestModal();
        });

        step("Fill request modal fields", () -> {
            mainPage.fillFirstNameField()
                    .fillLastNameField()
                    .fillPhoneField()
                    .fillEmailField()
                    .fillMessageField()
                    .signPrivacyPolicy();
        });

        step("Submit request", () -> {
            mainPage.makeARequest();
        });
    }
}
