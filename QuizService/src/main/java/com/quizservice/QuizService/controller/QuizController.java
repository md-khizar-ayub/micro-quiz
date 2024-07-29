package com.quizservice.QuizService.controller;

import com.quizservice.QuizService.entity.Quiz;
import com.quizservice.QuizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping()
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz){
        Quiz new_quiz = quizService.create(quiz);
        return ResponseEntity.ok(new_quiz);
    }

    @GetMapping
    public List<Quiz> get(){
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz get( @PathVariable Long id){
        return  quizService.get(id);
    }

}
