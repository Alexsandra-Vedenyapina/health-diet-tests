package ru.healthdiet.tests;

import org.junit.jupiter.api.Test;
import ru.healthdiet.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest extends TestBase{
    LoginPage loginPage= new LoginPage();

    @Test
    public void testSuccessfulLogin(){
        loginPage.clickButton()
                .setLogin("TestQA")
                .setPassword("TestQA951852")
                .clickLoginButton();

        //•	ОР: Успешно авторизоравались. Отображается главное меню и логин пользователя.
        $(".mzr-top-menu-content").shouldBe(visible);
        $(".mzr-top-menu-content").shouldHave(text("Общая лента"));
        $(".mzr-top-menu-name").shouldHave(text("Тест Тестович Тестов"));

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
