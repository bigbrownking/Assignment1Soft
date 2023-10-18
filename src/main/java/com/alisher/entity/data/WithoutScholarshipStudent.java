package com.alisher.entity.data;

public class WithoutScholarshipStudent extends StudentDecorator{
    public WithoutScholarshipStudent(Data data) {
        super(data);
    }
    public String grantData(){
        return "out scholarship ";
    }

    @Override
    public String showData() {
        return super.showData() + grantData();
    }

}

