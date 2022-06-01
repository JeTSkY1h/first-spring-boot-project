package com.example.firstspringbootproject;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepo studentRepo;

    StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents(){
        return studentRepo.getStudents();
    }

    public Student getStudent(String id){
        Optional<Student> res = studentRepo.getStudent(id);
        if (res.isEmpty()) throw new RuntimeException("id " + id + " Wurde nicht gefunden.");
        return res.get();
    }

    public void addStudent(Student studentToadd){
        studentRepo.addStudent(studentToadd);
    }

}