package com.alisher.entity.canteen;

public class Canteen {

    public Dish makeOrder(String dishType, String description) {
        dishType = dishType.trim().toLowerCase();
        if(dishType.equals("first meal")) return new FirstMeal(description);
        else if(dishType.equals("second meal")) return new SecondMeal(description);
        else if(dishType.equals("set meal")) return new SetMeal(description);
        else return null;
    }
    public void showMenu(){
        System.out.println("First meal: borsch, rassolnik, chicken soup");
        System.out.println("Second meal: rice, pasta, buckwheat");
        System.out.println("Or you can combine and order set dish");
    }
}
