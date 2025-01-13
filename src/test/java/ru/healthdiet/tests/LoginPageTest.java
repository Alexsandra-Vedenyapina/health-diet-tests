package ru.healthdiet.tests;

import org.junit.jupiter.api.Test;
import ru.healthdiet.pages.LoginPage;
import ru.healthdiet.pages.MainPage;

import java.util.Locale;

import static ru.healthdiet.tests.TestData.*;
import static ru.healthdiet.utils.RandomUtils.getRandomLogin;
import static ru.healthdiet.utils.RandomUtils.getRandomPassword;

public class LoginPageTest extends TestBase{
    LoginPage loginPage= new LoginPage();
    MainPage mainPage = new MainPage();



    @Test
    public void testSuccessfulLogin(){
        loginPage.clickButton()
                .setLogin(validLogin)
                .setPassword(validPassword)
                .clickLoginButton();

        mainPage.verifyElementMainPageVisible()
                .verifyNameUser(validNameUser);

    }

    @Test
    public void invalidPasswordErrorMessage(){
        String password = getRandomPassword(),
                login = getRandomLogin();

        loginPage.clickButton()
                .setLogin(login)
                .setPassword(password)
                .clickLoginButton();

        loginPage.verifyWarningIsVisible()
                        .verifyIWarningText(incorrectPasswordMessage);
    }

}
