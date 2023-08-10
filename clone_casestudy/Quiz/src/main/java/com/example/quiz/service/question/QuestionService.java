package com.example.quiz.service;

import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.service.question.QuestionListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    public List<QuestionListResponse> getAllQuestion(){
        return questionRepository.findAll();
    }
}
