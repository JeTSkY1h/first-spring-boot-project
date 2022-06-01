package student;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents(){
        return studentRepo.getStudents();
    }

    public Optional<Student> getStudent(String id){
        Optional<Student> res = studentRepo.getStudent(id);
        return res;
    }

    public void addStudent(Student studentToadd){
        studentRepo.addStudent(studentToadd);
    }

}