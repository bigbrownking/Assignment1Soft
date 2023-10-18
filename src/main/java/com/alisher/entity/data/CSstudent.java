package com.alisher.entity.data;

public class CSstudent extends StudentDecorator{
    public CSstudent(Data data) {
        super(data);
    }
    public String csData(){
        return "and I am CS student";
    }
    @Override
    public String showData() {
        return super.showData() + csData();
    }

}
