package com.alisher.entity.people;

public class Rector extends Person{
    public Rector(int id, String name, String surname) {
        super(id, name, surname);
    }

    public Rector() {
        super();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }
    public void receiveMessage(Student student,String message){
        if(message.equalsIgnoreCase("I want to change group")) changeGroup(student);
        else if(message.equalsIgnoreCase("When will the scholarship be given?")) infoScholarship(student);
        else doNotDisturbMe(student);
    }
    private void changeGroup(Student student) {
        System.out.println("No problem");
        String group = student.getGroup();
        String newGroup = group.contains("SE") ? group.replace("SE", "CS") : group.replace("CS", "SE");
        student.setGroup(newGroup);
    }
    private void infoScholarship(Student student){
        if(student.getGPA() >= 3.0) System.out.println("After 5 days");
        else System.out.println("You don't have one");
    }
    private void doNotDisturbMe(Student student){
        System.out.println("Don't disturb me, " + student.getName());

    }
}
