package com.examServer.ExamServer.service;

import com.examServer.ExamServer.model.exam.Category;
import com.examServer.ExamServer.model.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {


    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizes();
    public Quiz getQuiz(Long id);
    public void deleteQuiz(Long id);


   public List<Quiz> getQuizOfCategory(Category category);

   public List<Quiz> getActiveQuizzes();

   public List<Quiz> getActiveQuizzesOfCategory(Category category);

}
