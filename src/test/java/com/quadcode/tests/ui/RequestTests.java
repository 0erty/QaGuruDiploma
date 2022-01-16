package com.quadcode.tests.ui;

import com.github.javafaker.Faker;
import com.quadcode.pages.MainPage;
import com.quadcode.tests.TestBase;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Story("Login tests")
@Tag("QuadCode")
public class RequestTests extends TestBase {

    MainPage mainPage = new MainPage();
    Faker faker = new Faker();

    private final String firstName = faker.name().firstName(),
                         lastName = faker.name().lastName(),
                         phoneNumber = faker.phoneNumber().cellPhone(),
                         email = faker.internet().emailAddress();

    @Test
    @DisplayName("Successful request submission from Quadcode main page (UI)")
    void requestSentTest() {
        step("Open login page", () -> {
            open(baseUrl);
            mainPage.checkWelcomeTitle();
        });

        step("Open request modal", () -> {
            mainPage.clickContactBtn()
                    .checkRequestModal();
        });

        step("Fill request modal fields", () -> {
            mainPage.fillFirstNameField(firstName)
                    .fillLastNameField(lastName)
                    .fillPhoneField(phoneNumber)
                    .fillEmailField(email)
                    .fillMessageField()
                    .signPrivacyPolicy();
        });

        step("Submit request", () -> {
            mainPage.makeARequest()
                    .checkSuccessModal();
        });
    }
}
