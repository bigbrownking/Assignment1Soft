package com.alisher.entity.canteen;

public class FactoryChoice {
    public static Canteen getCanteen(int choice){
        return switch (choice) {
            case 1 -> new FirstMealFactory();
            case 2 -> new SecondMealFactory();
            case 3 -> new SetMealFactory();
            default -> null;
        };
    }
}
