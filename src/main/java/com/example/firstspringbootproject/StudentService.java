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
        return studentRepo.getStudent(id);
    }

    public void addStudent(Student studentToadd){
        studentRepo.addStudent(studentToadd);
    }

}