package com.alisher.entity.canteen;

public record SetMeal(String description) implements Dish {

    @Override
    public int price() {
        return 1400;
    }
}
