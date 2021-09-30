package com.example.demo.respository;

import com.example.demo.model.StudentPass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentPassRepository extends CrudRepository<StudentPass, Long> { }
