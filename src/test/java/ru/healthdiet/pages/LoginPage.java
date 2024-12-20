package ru.healthdiet.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPage clickButton(){
        $("a.uk-button").click();
        return this;
    }

    public LoginPage setLogin(String login){
        $("[name='login']").setValue(login);
        return this;
    }

    public LoginPage setPassword(String password){
        $("[name='password']").setValue(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        $(".uk-button[value='login']").click();
        return this;
    }

    public LoginPage verifyWarningIsVisible(){
        $(".uk-alert").shouldBe(visible);
        return this;
    }

    public LoginPage verifyIWarningText(String warningText){
        $(".uk-alert").shouldHave(text(warningText));
        return this;
    }


}
