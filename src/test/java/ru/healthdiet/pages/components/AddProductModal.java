package ru.healthdiet.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.domProperty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AddProductModal {



    public void verifyProductAdditionModalIsDisplayed(){
        $(".mzr-add-food-to").shouldBe(visible);
    }

    public AddProductModal setProductWeight(String weight){
        $(".mzr-add-food-to").shouldBe(Condition.visible);
        $("input.t-weight").setValue(weight);
        return this;
    }

    public AddProductModal selectMealType(String mealType){
        $("div.mzr-add-food-to .uk-margin-top").$(byText(mealType)).click();
        return this;
    }

    public AddProductModal clickAddAndClose(){
        $("button.uk-button-primary").click();
        $("button.uk-button-primary").shouldNotBe(visible);

        return this;
    }

    public String getNameSelectedProduct (){
        String name = $(".t-food-name").getText();
        return name;
    }
}
