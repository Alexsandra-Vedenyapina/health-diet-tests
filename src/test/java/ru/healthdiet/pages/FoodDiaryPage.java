package ru.healthdiet.pages;


import com.github.javafaker.Food;
import io.qameta.allure.Step;
import ru.healthdiet.pages.components.FoodSearchComponent;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FoodDiaryPage {

    LoginPage loginPage=new LoginPage();
    FoodSearchComponent foodSearchComponent = new FoodSearchComponent();


    @Step("Открыть Дневник питания")
    public FoodDiaryPage openFoodDiary(){
        $("[href='/diary/foodDiary']").click();
        return this;
    }

    @Step("Ввести название продукта в поиск")
    public FoodDiaryPage setFoodProduct(String foodProduct){
        foodSearchComponent.setFood(foodProduct);
        return this;
    }

    @Step("Проверка отоборажения выбранного продукта {foodProduct} в приеме пищи {mealType}")
    public FoodDiaryPage verifyAddSelectedProductToCurrentDayDiet(String foodProduct, String mealType){
        $(".mzr-food-diary-racion").$(byText(mealType)).closest(".mzr-food-diary-intake")
                .$$(".el-food").last().shouldHave(text(foodProduct));

        return this;

        }
    }



