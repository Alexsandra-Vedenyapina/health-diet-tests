package ru.healthdiet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.healthdiet.pages.FoodDiaryPage;
import ru.healthdiet.pages.components.AddProductModal;
import ru.healthdiet.pages.components.FoodSearchComponent;

import static ru.healthdiet.tests.TestData.foodProductsList;
import static ru.healthdiet.utils.RandomUtils.getRandomItemFromArray;

@DisplayName("Тесты поисового блока продутков питания")
public class FoodSearchComponentTest {

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

            foodSearch.setFood(foodProduct);

            foodSearch.verifySearchResult(foodProduct);

        }
}
