package com.nejdetkadirr.studentsapp.controllers;

import com.nejdetkadirr.studentsapp.repositories.LessonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LessonController {

    private final LessonRepository lessonRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @RequestMapping("lessons")
    public String getLessons(Model model) {
        model.addAttribute("lessons", lessonRepository.findAll());
        return "lessons/index";
    }
}
