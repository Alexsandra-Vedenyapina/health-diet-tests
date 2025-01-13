package ru.healthdiet.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FoodSearchComponent {
    public void setFood(String foodProduct){
        $("input.t-search-food").setValue(foodProduct);
    }

    public void verifySearchResult(String foodProduct){
        $$(".mzr-tree-node").
                forEach(item ->item.shouldHave(Condition.text(foodProduct)));
    }

}
