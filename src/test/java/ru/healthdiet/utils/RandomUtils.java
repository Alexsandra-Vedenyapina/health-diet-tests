package ru.healthdiet.utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomUtils {


    public static String getRandomPassword(){
        return new Faker().internet().password();
    }

    public static String getRandomLogin(){
        return new Faker().name().username();
    }

    public static String getRandomItemFromArray(String [] foodProducts){
        String randomFoodProduct = foodProducts[new Random().nextInt(foodProducts.length)];
        return  randomFoodProduct;
    }

    public  static int getRandomNumber(int min, int max){
        return new Random().nextInt((max-min)+1)+min;
    }


}
