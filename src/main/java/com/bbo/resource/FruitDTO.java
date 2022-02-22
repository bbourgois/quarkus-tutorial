package com.bbo.resource;

import com.bbo.model.Fruit;
import com.bbo.model.FruityVice;
import com.bbo.model.Season;

public class FruitDTO {

    private String name;
    private Season season;
    private double carbohydrates;
    private double calories;

    private FruitDTO(String name, Season season, double carbohydrates, double calories) {
        this.name = name;
        this.season = season;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public static FruitDTO of(Fruit fruit, FruityVice fruityVice) {
        return new FruitDTO(fruit.name,
                fruit.season,
                fruityVice.getNutritions().getCarbohydrates(),
                fruityVice.getNutritions().getCalories());
    }

    public String getName() {
        return name;
    }

    public Season getSeason() {
        return season;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getCalories() {
        return calories;
    }
}
