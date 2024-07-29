package com.quizservice.QuizService.service.Impl;

import com.quizservice.QuizService.client.QuestionClient;
import com.quizservice.QuizService.entity.Quiz;
import com.quizservice.QuizService.repository.QuizRepository;
import com.quizservice.QuizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz create(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {

        return quizRepository.findAll().stream().map(q->{
            q.setQuestionList(questionClient.get(q.getId()));
            return q;
        }).collect(Collectors.toList());
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz =quizRepository.findById(id).orElseThrow(() -> new RuntimeException("No Quiz Found Exception"));
        quiz.setQuestionList(questionClient.get(quiz.getId()));
        return quiz;

    }
}
