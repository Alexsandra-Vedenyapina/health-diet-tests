package ru.healthdiet.tests;

public class TestData {

    public static String
            validLogin = "TestQA",
            validPassword = "TestQA951852",
            validNameUser ="Тест Тестович Тестов",
            incorrectPasswordMessage = "Неправильный пароль";

    public static String incorrectLoginMessage(String loginName){
        return "Пользователя с таким логином ("+ loginName+") не существует";
    }


    public static String[] foodProductsList={
            "Масло"," яблоко", "хлеб", "молоко", "говядина", "курица"
    };




}
