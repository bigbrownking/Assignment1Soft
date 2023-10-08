package com.alisher.entity.data;

public class ScholarshipStudent extends StudentDecorator{
    public ScholarshipStudent(Data data) {
        super(data);
    }
    public String scholarShipData(){
        return " scholarship ";
    }
    @Override
    public String showData() {
        return super.showData() + scholarShipData();
    }

    @Override
    public void setData(Data data) {
        super.setData(data);
    }
}
