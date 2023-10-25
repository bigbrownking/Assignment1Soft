package com.alisher.entity.canteen;

public class FirstMeal implements Dish{
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FirstMeal(String description) {
        this.description = description;
    }

    @Override
    public int price() {
        return 600;
    }

}
