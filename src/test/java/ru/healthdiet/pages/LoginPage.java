package ru.healthdiet.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @Step("Кликнуть по кнопке Войти на гланой странице")
    public LoginPage clickButton(){
        $("a.uk-button").click();
        return this;
    }

    @Step ("Ввести логин")
    public LoginPage setLogin(String login){
        $("[name='login']").setValue(login);
        return this;
    }

    @Step ("Ввести пароль")
    public LoginPage setPassword(String password){
        $("[name='password']").setValue(password);
        return this;
    }

    @Step ("Кликнуть по кнопке Войти на странице авторизации")
    public LoginPage clickLoginButton(){
        $(".uk-button[value='login']").click();
        return this;
    }

    @Step ("Проверка наличия сообщения об  ошибке")
    public LoginPage verifyWarningIsVisible(){
        $(".uk-alert").shouldBe(visible);
        return this;
    }

    @Step ("Проверка текста ошибки {warningText}")
    public LoginPage verifyIWarningText(String warningText){
        $(".uk-alert").shouldHave(text(warningText));
        return this;
    }

    @Attachment(value ="Screenshot", type="image/png", fileExtension=".png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }





}
