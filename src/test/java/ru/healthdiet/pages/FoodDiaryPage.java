package ru.healthdiet.pages;


import ru.healthdiet.pages.components.FoodSearchComponent;


import static com.codeborne.selenide.Selenide.*;


public class FoodDiaryPage {

    LoginPage loginPage=new LoginPage();
    FoodSearchComponent foodSearchComponent = new FoodSearchComponent();



    public FoodDiaryPage openFoodDiary(){
        $("[href='/diary/foodDiary']").click();
        return this;
    }

    public FoodDiaryPage setFoodProduct(String foodProduct){
        foodSearchComponent.setFood(foodProduct);
        return this;
    }

    public FoodDiaryPage verifySearchResultsIncludeEnteredText(String foodProduct){
        foodSearchComponent.verifySearchResult(foodProduct);
        return this;
    }
}
