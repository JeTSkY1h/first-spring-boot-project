package student;

import java.util.*;

public class Student {
    private  String id = UUID.randomUUID().toString();
    private  String name;

    public Student(String name){
        this.name = name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

        public String getId() {
        return id;
    }

}