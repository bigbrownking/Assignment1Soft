package com.alisher.entity.canteen;

public class SecondMeal implements Dish{
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SecondMeal(String description) {
        this.description = description;
    }

    @Override
    public int price() {
        return 1000;
    }
}
