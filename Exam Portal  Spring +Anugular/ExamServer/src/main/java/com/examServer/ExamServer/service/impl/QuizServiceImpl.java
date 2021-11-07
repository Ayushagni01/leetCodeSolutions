package com.examServer.ExamServer.service.impl;

import com.examServer.ExamServer.model.exam.Category;
import com.examServer.ExamServer.model.exam.Quiz;
import com.examServer.ExamServer.repo.QuizRepository;
import com.examServer.ExamServer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long id) {

        return this.quizRepository.findById(id).get();
    }

    @Override
    public void deleteQuiz(Long id) {

        this.quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> getQuizOfCategory(Category category) {
        return this.quizRepository.findBycategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category category) {
        return this.quizRepository.findByCategoryAndActive(category,true);
    }

    //get active quizes



}
