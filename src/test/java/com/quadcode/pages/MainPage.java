package com.quadcode.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    Faker faker = new Faker();

    private SelenideElement WelcomeInner = $(".welcome__inner"),
            TryQuadcodeBrokerageBtn = $(".welcome__inner > a"),
            RequestModalTitle = $(".form__title"),
            FirstNameField = $("#first_name"),
            LastNameField = $("#last_name"),
            PhoneField = $("#phone"),
            EmailField = $("#email"),
            MessageField = $("#message"),
            PrivacyPolicyCheckbox = $(".custom-checkbox__label-box"),
            SubmitBtn = $("[name='submit']");

    private final String firstName = faker.name().firstName(),
                         lastName = faker.name().lastName(),
                         phoneNumber = faker.phoneNumber().cellPhone(),
                         email = faker.internet().emailAddress(),
                         message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.";


    public MainPage checkWelcomeInner() {
        WelcomeInner.shouldBe(Condition.visible);
        return this;
    }

    public MainPage clickContactBtn() {
        TryQuadcodeBrokerageBtn.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPage checkRequestModal() {
        RequestModalTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Enhance your business with industry proven software"));
        return this;
    }

    public MainPage fillFirstNameField() {
        FirstNameField.shouldBe(Condition.visible).val(firstName);
        return this;
    }

    public MainPage fillLastNameField() {
        LastNameField.shouldBe(Condition.visible).val(lastName);
        return this;
    }

    public MainPage fillPhoneField() {
        PhoneField.shouldBe(Condition.visible).val(phoneNumber);
        return this;
    }

    public MainPage fillEmailField() {
        EmailField.shouldBe(Condition.visible).val(email);
        return this;
    }

    public MainPage fillMessageField() {
        MessageField.shouldBe(Condition.visible).val(message);
        return this;
    }

    public MainPage signPrivacyPolicy() {
        PrivacyPolicyCheckbox.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPage makeARequest() {
        SubmitBtn.shouldBe(Condition.visible); //.click(); закоментил чтобы не спамить
        return this;
    }
}
