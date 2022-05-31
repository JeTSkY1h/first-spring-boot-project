package com.example.firstspringbootproject;

public class Student {
    private final String name;
    private final int age;
    private final String subject;
    
    Student(String name, int age, String subject){
        this.age = age;
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getSubject() {
        return subject;
    }

}