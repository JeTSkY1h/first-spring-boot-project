package com.example.firstspringbootproject;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    Map<String, Student> students = new HashMap<String, Student>();


    public List<Student> getStudents(){
        return students.values().stream().toList();
    }

    public Student getStudent(String id){
        return students.get(id);
    }

    public void addStudent(Student studentToadd){
        students.put(studentToadd.getId(), studentToadd);
    }


}