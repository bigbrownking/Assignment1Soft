package com.alisher.entity.canteen;

public interface Canteen {
    Dish makeOrder(String description);
    void showMenu();
}