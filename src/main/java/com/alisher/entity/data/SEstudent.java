package com.alisher.entity.data;

public class SEstudent extends StudentDecorator{
    public SEstudent(Data data) {
        super(data);
    }
    public String seData(){
        return "and I am SE student";
    }

    @Override
    public String showData() {
        return super.showData() + seData();
    }
}
