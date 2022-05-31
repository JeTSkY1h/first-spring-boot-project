package com.example.firstspringbootproject;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    
    public StudentController(StudentService service) {
        this.service = service;
    }
    List<Student> students = new ArrayList<>();

    @GetMapping()
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id){
        return service.getStudent(id);
    }

    @PostMapping()
    public void createStudent(@RequestBody Student student){
        service.addStudent(student);
    }
}