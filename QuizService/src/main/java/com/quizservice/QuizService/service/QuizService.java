package com.quizservice.QuizService.service;

import com.quizservice.QuizService.entity.Question;
import com.quizservice.QuizService.entity.Quiz;

import java.util.List;

public interface QuizService {

    public Quiz create(Quiz quiz);

    public List<Quiz> get();

    public Quiz get(Long id);



}
