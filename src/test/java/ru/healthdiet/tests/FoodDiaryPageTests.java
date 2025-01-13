package ru.healthdiet.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.healthdiet.pages.FoodDiaryPage;

public class FoodDiaryPageTests {
    static FoodDiaryPage foodDiary=new FoodDiaryPage();

    @BeforeAll
    public static void beforeAll(){
        foodDiary.authorization()
                .openFoodDiary();
    }

    @Test
    public void searchProductByText(){

        foodDiary.setFoodProduct("хлеб");

        foodDiary.verifySearchResultsIncludeEnteredText("хлеб");

    }
}
