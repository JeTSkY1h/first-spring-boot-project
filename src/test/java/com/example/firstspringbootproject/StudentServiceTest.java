package com.example.firstspringbootproject;

import static org.mockito.Mockito.when;

import java.util.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StudentServiceTest {
    Student motoko = new Student("Motoko Kusnagi");
    Student asterix = new Student("Asterix");
    @Test
    void ShouldReturnStudent(){
        //GIVEN
        StudentRepo studentRepo = Mockito.mock(StudentRepo.class);
        StudentService studentService = new StudentService(studentRepo);
        when(studentRepo.getStudent("4711"))
            .thenReturn(Optional.ofNullable(motoko));
        //WHEN 
        Student actual = studentService.getStudent("4711");
        //then
        assertThat(actual).isEqualTo(motoko);
    }

    @Test
    void shouldReturnStudentList(){
        //GIVEN
        StudentRepo studentRepo = Mockito.mock(StudentRepo.class);
        StudentService studentService = new StudentService(studentRepo);
        when(studentRepo.getStudents()).thenReturn(List.of(motoko, asterix));
        //WHEN
        List <Student> actual = studentService.getStudents();

        assertThat(actual).containsExactlyInAnyOrderElementsOf(List.of(motoko, asterix));
    }

    @Test
    void shouldAddStudent(){
        //GIVEN
        StudentRepo studentRepo = Mockito.mock(StudentRepo.class);
        StudentService studentService = new StudentService(studentRepo);
        when(studentRepo.getStudents()).thenReturn(List.of(motoko, asterix));

        //WHEN
        studentService.addStudent(asterix);

        Mockito.verify(studentRepo).addStudent(asterix);
    }
}