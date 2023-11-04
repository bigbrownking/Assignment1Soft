package com.alisher.entity.canteen;

public class SecondMealFactory implements Canteen{
    @Override
    public Dish makeOrder(String description) {
        return new SecondMeal(description);
    }

    @Override
    public void showMenu() {
        System.out.println("Second Meal Menu:");
        System.out.println("1. Rice");
        System.out.println("2. Spaghetti");
        System.out.println("3. French Meat");
    }
}
