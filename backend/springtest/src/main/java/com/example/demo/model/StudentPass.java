package com.example.demo.model;


import javax.persistence.*;

import com.example.demo.model.Student;
import com.fasterxml.jackson.annotation.*;

@Entity
public class StudentPass {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @JsonBackReference
    private Student student;

    public StudentPass() {}

    public StudentPass(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
