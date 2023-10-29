package com.alisher.entity.canteen;

public class SetMeal implements Dish{
    private String description;
    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SetMeal(String description) {
        this.description = description;
    }

    @Override
    public int price() {
        return 1400;
    }
}
