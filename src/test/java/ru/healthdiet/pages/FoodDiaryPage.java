package ru.healthdiet.pages;


import com.github.javafaker.Food;
import ru.healthdiet.pages.components.FoodSearchComponent;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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

    public FoodDiaryPage verifyAddSelectedProductToCurrentDayDiet(String foodProduct, String mealType){
        $(".mzr-food-diary-racion").$(byText(mealType)).closest(".mzr-food-diary-intake")
                .$$(".el-food").last().shouldHave(text(foodProduct));

        return this;

        }
    }



