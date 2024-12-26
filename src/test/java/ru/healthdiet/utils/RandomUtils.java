package ru.healthdiet.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {


    public static String getRandomPassword(){
        return new Faker().internet().password();
    }

    public static String getRandomLogin(){
        return new Faker().name().username();
    }
}
