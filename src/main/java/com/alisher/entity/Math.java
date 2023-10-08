package com.alisher.entity;

public class Math implements Subject{
    private static Math math = new Math();
    private Math(){}
    public static Math getMath(){
        return math;
    }
    @Override
    public String toString() {
        return "Math";
    }
}
