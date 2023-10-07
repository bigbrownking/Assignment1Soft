package com.alisher.entity;

public class Programming implements Subject{
    private static Programming programming = new Programming();
    private Programming(){}
    public static Programming getProgramming(){
        return programming;
    }

    @Override
    public String toString() {
        return "Programming";
    }

    @Override
    public int getCredit() {
        return 5;
    }
}
