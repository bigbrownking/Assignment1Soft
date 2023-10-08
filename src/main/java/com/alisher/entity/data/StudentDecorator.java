package com.alisher.entity.data;

public abstract class StudentDecorator implements Data{
    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public StudentDecorator(Data data) {
        this.data = data;
    }
    @Override
    public String showData() {
        return data.showData();
    }
}
