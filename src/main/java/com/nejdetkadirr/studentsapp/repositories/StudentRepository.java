package com.nejdetkadirr.studentsapp.repositories;

import com.nejdetkadirr.studentsapp.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
