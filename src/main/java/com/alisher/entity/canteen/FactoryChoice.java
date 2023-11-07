package com.alisher.entity.canteen;

public class FactoryChoice {
    public static Canteen getCanteen(int choice){
        switch (choice) {
            case 1:
                return new FirstMealFactory();
            case 2:
                return new SecondMealFactory();
            case 3:
                return new SetMealFactory();
        }
        return null;
    }
}
