package com.alisher.entity;

public class History implements Subject{
    private static History history = new History();
    private History(){}
    public static History getHistory(){
        return history;
    }
    @Override
    public String toString() {
        return "History";
    }

    @Override
    public int getCredit() {
        return 2;
    }
}
