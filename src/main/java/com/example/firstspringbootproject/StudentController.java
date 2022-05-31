package com.example.firstspringbootproject;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {


    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Motoko Kusnagi",26,"Trancendence"));
        students.add(new Student("Yumeko Jabami",18,"Gambling"));
        students.add(new Student("Akatsuki",10,"Assasination"));
        students.add(new Student("Shiro",11,"Playing Games"));
        // List<String> students = List.of("Motoko Kusangi", "Yumeko Jabami","Akatsuki","Shiro");
        return students; 
    }
}