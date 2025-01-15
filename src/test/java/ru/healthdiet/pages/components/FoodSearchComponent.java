package ru.healthdiet.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FoodSearchComponent {

    public FoodSearchComponent setFood(String foodProduct){
        $("input.t-search-food").shouldBe(Condition.visible).setValue(foodProduct);
        return this;
    }

    public FoodSearchComponent verifySearchResult(String foodProduct){
        $$(".mzr-tree-node").
                forEach(item ->item.shouldHave(Condition.text(foodProduct)));
        return this;
    }

    public FoodSearchComponent clickOnProduct(int index){
        $(".mzr-tree-node.uk-text-bold-semi").shouldBe(Condition.visible).sibling(index).click();
        return this;
    }


}
