package ru.healthdiet.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.healthdiet.pages.LoginPage;
import ru.healthdiet.pages.MainPage;


import static ru.healthdiet.tests.TestData.*;
import static ru.healthdiet.utils.RandomUtils.getRandomLogin;
import static ru.healthdiet.utils.RandomUtils.getRandomPassword;

public class LoginPageTest extends TestBase{

    LoginPage loginPage= new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    @Feature("Страница авторизации МЗР") // пишем какая фича проверяется
    @Story("Успешная авторизация пользователя") // пишем, что с ней происходит (CRUD)
    @Owner("vedenyapina") // ответственный
    @Severity(SeverityLevel.BLOCKER) // серьезность
    @Tag("BLOCKER")
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Успешная авторизация пользователя на МЗР")
    public void testSuccessfulLogin(){
        SelenideLogger.addListener("allure", new AllureSelenide());


        loginPage.clickButton()
                .setLogin(validLogin)
                .setPassword(validPassword)
                .clickLoginButton();

        mainPage.verifyElementMainPageVisible()
                .verifyNameUser(validNameUser);
        loginPage.takeScreenshot();

    }

    @Test
    @Feature("Страница авторизации МЗР") // пишем какая фича проверяется
    @Story("Ошибка авторизации пользователя") // пишем, что с ней происходит (CRUD)
    @Owner("vedenyapina") // ответственный
    @Severity(SeverityLevel.BLOCKER) // серьезность
    @Tag("BLOCKER")
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Сообщение об ошибке авторизации с неверным паролем")
    public void invalidPasswordErrorMessage(){
        String password = getRandomPassword(),
                login = validLogin;

        loginPage.clickButton()
                .setLogin(login)
                .setPassword(password)
                .clickLoginButton();

        loginPage.verifyWarningIsVisible()
                        .verifyIWarningText(incorrectPasswordMessage);
    }

    @Test
    @Feature("Страница авторизации МЗР") // пишем какая фича проверяется
    @Story("Ошибка авторизации пользователя") // пишем, что с ней происходит (CRUD)
    @Owner("vedenyapina") // ответственный
    @Severity(SeverityLevel.BLOCKER) // серьезность
    @Tag("BLOCKER")
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Сообщение об ошибке авторизации с неверным логином")
    public void invalidLoginErrorMessage(){
        String password = getRandomPassword(),
                login = getRandomLogin();

        loginPage.clickButton()
                .setLogin(login)
                .setPassword(password)
                .clickLoginButton();

        loginPage.verifyWarningIsVisible()
                .verifyIWarningText(incorrectLoginMessage(login));
    }

}
