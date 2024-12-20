package ru.healthdiet.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPage verifyElementMainPageVisible(){
        $(".mzr-top-menu-content").shouldBe(visible);
        $(".mzr-top-menu-content").shouldHave(text("Общая лента"));
        return this;
    }

    public MainPage verifyNameUser(String nameUser){

        $(".mzr-top-menu-name").shouldHave(text(nameUser));
        return  this;
    }

}
