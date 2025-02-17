package ru.healthdiet.tests;


import io.qameta.allure.Step;
import ru.healthdiet.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.healthdiet.tests.TestData.validLogin;
import static ru.healthdiet.tests.TestData.validPassword;

public class Authorization {

    LoginPage loginPage=new LoginPage();

    @Step("Авторизация в МЗР")
    public void authorization(){
        open("https://health-diet.ru/account/login");
        loginPage.setLogin(validLogin)
                .setPassword(validPassword)
                .clickLoginButton();
    }
}
