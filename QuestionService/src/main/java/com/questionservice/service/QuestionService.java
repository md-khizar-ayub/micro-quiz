package com.questionservice.service;

import com.questionservice.entity.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question> get();

    Question get(Long id);
    List<Question> getbyQuizId(Long quiz_id);
}
