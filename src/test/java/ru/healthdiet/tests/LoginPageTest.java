package ru.healthdiet.tests;

import org.junit.jupiter.api.Test;
import ru.healthdiet.pages.LoginPage;
import ru.healthdiet.pages.MainPage;

public class LoginPageTest extends TestBase{
    LoginPage loginPage= new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void testSuccessfulLogin(){
        loginPage.clickButton()
                .setLogin("TestQA")
                .setPassword("TestQA951852")
                .clickLoginButton();

        mainPage.verifyElementMainPageVisible()
                .verifyNameUser("Тест Тестович Тестов");

    }

    @Test
    public void invalidPasswordErrorMessage(){

        loginPage.clickButton()
                .setLogin("TestQA")
                .setPassword("TestQA9512")
                .clickLoginButton();

        loginPage.verifyWarningIsVisible()
                        .verifyIWarningText("Неправильный пароль");
    }

}
