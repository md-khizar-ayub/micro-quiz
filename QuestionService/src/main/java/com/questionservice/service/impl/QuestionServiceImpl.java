package com.questionservice.service.impl;

import com.questionservice.entity.Question;
import com.questionservice.repository.QuestionRepository;
import com.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question Not Found Exception"));
    }

    @Override
    public List<Question> getbyQuizId(Long quiz_id) {
        return questionRepository.findByQuizId(quiz_id);
    }

}
