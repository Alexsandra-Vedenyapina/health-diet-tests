package ru.healthdiet.tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.healthdiet.pages.FoodDiaryPage;
import ru.healthdiet.pages.components.AddProductModal;
import ru.healthdiet.pages.components.FoodSearchComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static ru.healthdiet.tests.TestData.foodProductsList;
import static ru.healthdiet.utils.RandomUtils.getRandomItemFromArray;

@DisplayName("Тесты страницы Дневника питания")
public class FoodDiaryPageTests {
    FoodDiaryPage foodDiary=new FoodDiaryPage();
    Authorization authorization=new Authorization();
    FoodSearchComponent foodSearch=new FoodSearchComponent();
    AddProductModal addProduct = new AddProductModal();


    @BeforeEach
    public void beforeEach(){
        authorization.authorization();
        foodDiary.openFoodDiary();
    }


    @Test
    @DisplayName("Выдается список продуктов содержащих введенный текст в поле поиска")
    @Tag("BLOKER")
    public void searchProductByText(){
        String foodProduct= getRandomItemFromArray(foodProductsList);

        foodDiary.setFoodProduct(foodProduct);

        foodDiary.verifySearchResultsIncludeEnteredText(foodProduct);

    }

    @ValueSource(strings = {"Завтрак", "Обед", "Ужин"})
    @ParameterizedTest(name="Успешно добавлен выбранный продукт на {0} в рацион текущего дня")
    @Tag("BLOKER")
    public void addProductToTodaysDiary(String mailType){
        String foodProduct= getRandomItemFromArray(foodProductsList);
        String inputNumber = "50";
        String selectProduct=null;

        foodSearch.setFood(foodProduct)
                .clickOnProduct(0);
        addProduct.setProductWeight(inputNumber)
                .selectMealType(mailType);
        selectProduct=addProduct.getNameSelectedProduct();
        addProduct.clickAddAndClose();

        foodDiary.verifyAddSelectedProductToCurrentDayDiet(selectProduct, mailType);

    }

}
