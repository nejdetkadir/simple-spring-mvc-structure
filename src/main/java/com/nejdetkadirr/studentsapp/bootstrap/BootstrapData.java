package com.nejdetkadirr.studentsapp.bootstrap;

import com.nejdetkadirr.studentsapp.domain.Lesson;
import com.nejdetkadirr.studentsapp.domain.Student;
import com.nejdetkadirr.studentsapp.repositories.LessonRepository;
import com.nejdetkadirr.studentsapp.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    public BootstrapData(StudentRepository studentRepository, LessonRepository lessonRepository) {
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create two lesson
        Lesson math = new Lesson("Math", "Zeynep Özer");
        Lesson DBMS = new Lesson("Database Management Systems", "Abdülkadir Özdemir");

        // Create 5 students
        for (int i = 0; i < 5; i++) {
            Student student = new Student("Name " + i,"Lastname " + i,15155 + i,"MIS");
            Lesson lesson = i % 2 == 0 ? math : DBMS;

            student.getLessons().add(lesson);
            lesson.getStudents().add(student);

            // If current index equal to 0, add another lesson
            if (i == 0) {
                student.getLessons().add(DBMS);
                DBMS.getStudents().add(student);
            }

            // Save
            studentRepository.save(student);
        }

        lessonRepository.save(math);
        lessonRepository.save(DBMS);

        System.out.println("Total lessons : " + lessonRepository.count());
        System.out.println("Total students : " + studentRepository.count());

        System.out.println("Math students : ");
        math.getStudents().forEach(student -> {
            System.out.println("-> " + student.getFirstName() + " " + student.getLastName());
        });

        System.out.println("DBMS students : ");
        DBMS.getStudents().forEach(student -> {
            System.out.println("-> " + student.getFirstName() + " " + student.getLastName());
        });
    }
}
