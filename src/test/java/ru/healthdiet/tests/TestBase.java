package ru.healthdiet.tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBase {


    @BeforeEach
    public  void beforeEach(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу авторизации МЗР", () ->{
            open("https://health-diet.ru/account/login");
        });


    }

}
