package ru.healthdiet.pages.components;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FoodSearchComponent {

    @Step("Ввести продукт {foodProduct} в поле поиска")
    public FoodSearchComponent setFood(String foodProduct){
        $("input.t-search-food").shouldBe(Condition.visible).setValue(foodProduct);
        return this;
    }

    @Step("Проверка вывода списка продуктов включающих введеный текст {foodProduct}")
    public FoodSearchComponent verifySearchResult(String foodProduct){
        $$(".mzr-tree-node").
                forEach(item ->item.shouldHave(Condition.text(foodProduct)));
        return this;
    }

    @Step("Кликнуть по {index +1} -му продукту в списке")
    public FoodSearchComponent clickOnProduct(int index){
        $(".mzr-tree-node.uk-text-bold-semi").shouldBe(Condition.visible).sibling(index).click();
        return this;
    }


}
