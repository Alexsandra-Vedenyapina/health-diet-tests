package ru.healthdiet.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    @Step ("Проверка наличия текста 'Общая лента' в главном меню")
    public MainPage verifyElementMainPageVisible(){
        $(".mzr-top-menu-content").shouldBe(visible);
        $(".mzr-top-menu-content").shouldHave(text("Общая лента"));
        return this;
    }

    @Step ("В главном меню ФИО пользователя  = '{nameUser}'")
    public MainPage verifyNameUser(String nameUser){

        $(".mzr-top-menu-name").shouldHave(text(nameUser));
        return  this;
    }

}
