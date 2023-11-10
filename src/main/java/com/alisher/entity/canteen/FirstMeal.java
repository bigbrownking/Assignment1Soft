package com.alisher.entity.canteen;

public record FirstMeal(String description) implements Dish {

    @Override
    public int price() {
        return 600;
    }

}
