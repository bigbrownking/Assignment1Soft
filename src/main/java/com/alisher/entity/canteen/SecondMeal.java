package com.alisher.entity.canteen;

public record SecondMeal(String description) implements Dish {

    @Override
    public int price() {
        return 1000;
    }
}
