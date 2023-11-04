package com.alisher.entity.canteen;
public class FirstMealFactory implements Canteen {
    @Override
    public Dish makeOrder(String description) {
        return new FirstMeal(description);
    }

    @Override
    public void showMenu() {
        System.out.println("First Meal Menu:");
        System.out.println("1. Borsch");
        System.out.println("2. Rassolnik");
        System.out.println("3. Chicken Soup");
    }
}
