package com.alisher.entity.canteen;

public class SetMealFactory implements Canteen{
    @Override
    public Dish makeOrder(String description) {
        return new SetMeal(description);
    }

    @Override
    public void showMenu() {
        System.out.println("Set Meal Menu:");
        System.out.println("1. Rassolnik + Spaghetti");
        System.out.println("2. Chicken soup + rise");
    }
}
