package ru.healthdiet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.commands.PressTab;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static ru.healthdiet.tests.TestData.validLogin;
import static ru.healthdiet.tests.TestData.validPassword;

public class FoodDiaryPage {

    LoginPage loginPage=new LoginPage();

    public FoodDiaryPage authorization(){
        open("https://health-diet.ru/account/login");
        loginPage.setLogin(validLogin)
                .setPassword(validPassword)
                .clickLoginButton();
        return this;
    }

    public FoodDiaryPage openFoodDiary(){
        $("[href='/diary/foodDiary']").click();
        return this;
    }

    public FoodDiaryPage setFoodProduct(String foodProduct){
        $("input.t-search-food").setValue(foodProduct);
        return this;
    }

    public FoodDiaryPage verifySearchResultsIncludeEnteredText(String foodProduct){
        $$(".mzr-tree-node").
                forEach(item ->item.shouldHave(Condition.text(foodProduct)));
        return this;
    }
}
