package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.respository.StudentRepository;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public void insert(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getById(Long id) { return studentRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)); }

    @Transactional
    public void updateById(Long Id, Student student) {
        Student existingStudent = studentRepository.findById(Id).orElse(new Student());
        student.setId(existingStudent.getId());
        studentRepository.save(student);
    }

    @Transactional
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}