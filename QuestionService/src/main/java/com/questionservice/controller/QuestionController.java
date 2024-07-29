package com.questionservice.controller;

import com.questionservice.entity.Question;
import com.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question){
     Question new_question = questionService.create(question);
             return new_question;
    }

    @GetMapping
    public List<Question> get(){
        return questionService.get();
    }

    @GetMapping("/{id}")
    public Question get(@PathVariable Long id){
        return  questionService.get(id);
    }

    @GetMapping("/quiz/{quiz_id}")
    public List<Question> getbyQuizId(@PathVariable Long quiz_id){

        return  questionService.getbyQuizId(quiz_id);
    }

}
