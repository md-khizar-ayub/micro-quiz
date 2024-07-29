package com.quizservice.QuizService.client;

import com.quizservice.QuizService.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8091", name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quiz_id}")
    public List<Question> get(@PathVariable Long quiz_id);
}
