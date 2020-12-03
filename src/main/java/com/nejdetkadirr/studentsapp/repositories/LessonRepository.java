package com.nejdetkadirr.studentsapp.repositories;

import com.nejdetkadirr.studentsapp.domain.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
