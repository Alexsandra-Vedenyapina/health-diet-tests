package ru.healthdiet.tests;


import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {


    @BeforeEach
    public  void beforeEach(){
        open("https://health-diet.ru");

    }

}
