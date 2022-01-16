package com.quadcode.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement welcomeTitle = $(".welcome__inner > header > h1"),
                            tryQuadcodeBrokerageBtn = $(".welcome__inner > a"),
                            requestModalTitle = $(".form__title"),
                            firstNameField = $("#first_name"),
                            lastNameField = $("#last_name"),
                            phoneField = $("#phone"),
                            emailField = $("#email"),
                            messageField = $("#message"),
                            privacyPolicyCheckbox = $(".custom-checkbox__label-box"),
                            submitBtn = $("[name='submit']"),
                            successModal = $(".form-message.form-success"),
                            successModalTitle = $(".form-message.form-success > div > div.form-message__title"),
                            getSuccessModalOkBtn = $(".form-message.form-success > div > div > a.custom-button.js-close-modal");

    private final String message = "Lorem ipsum dolor sit amet.",
                         welcomeMessage = "Launch the brokerage business in just a few clicks",
                         modalTitle = "Enhance your business with industry proven software",
                         successMessage = "Your request was successfully sent!";


    public MainPage checkWelcomeTitle() {
        welcomeTitle.shouldBe(visible).shouldHave(text(welcomeMessage));
        return this;
    }

    public MainPage clickContactBtn() {
        tryQuadcodeBrokerageBtn.click();
        return this;
    }

    public MainPage checkRequestModal() {
        requestModalTitle.shouldBe(visible).shouldHave(text(modalTitle));
        return this;
    }

    public MainPage fillFirstNameField(String firstName) {
        firstNameField.shouldBe(visible).val(firstName);
        return this;
    }

    public MainPage fillLastNameField(String lastName) {
        lastNameField.shouldBe(visible).val(lastName);
        return this;
    }

    public MainPage fillPhoneField(String phoneNumber) {
        phoneField.shouldBe(visible).val(phoneNumber);
        return this;
    }

    public MainPage fillEmailField(String email) {
        emailField.shouldBe(visible).val(email);
        return this;
    }

    public MainPage fillMessageField() {
        messageField.shouldBe(visible).val(message);
        return this;
    }

    public MainPage signPrivacyPolicy() {
        privacyPolicyCheckbox.click();
        return this;
    }

    public MainPage makeARequest() {
        submitBtn.click();
        return this;
    }

    public MainPage checkSuccessModal() {
        successModal.shouldBe(visible);
        successModalTitle.shouldBe(visible).shouldHave(text(successMessage));
        getSuccessModalOkBtn.click();
        return this;
    }
}
