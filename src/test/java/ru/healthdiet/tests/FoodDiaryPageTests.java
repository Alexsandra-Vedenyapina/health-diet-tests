package ru.healthdiet.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.healthdiet.pages.FoodDiaryPage;

import static ru.healthdiet.tests.TestData.foodProductsList;
import static ru.healthdiet.utils.RandomUtils.getRandomItemFromArray;

public class FoodDiaryPageTests {
    FoodDiaryPage foodDiary=new FoodDiaryPage();
    Authorization authorization=new Authorization();

    @BeforeEach
    public void beforeEach(){
        authorization.authorization();
        foodDiary.openFoodDiary();
    }

    @Test
    public void searchProductByText(){
        String foodProduct= getRandomItemFromArray(foodProductsList);

        foodDiary.setFoodProduct(foodProduct);

        foodDiary.verifySearchResultsIncludeEnteredText(foodProduct);

    }
}
