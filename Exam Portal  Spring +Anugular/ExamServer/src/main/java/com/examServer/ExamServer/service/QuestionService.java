package com.examServer.ExamServer.service;

import com.examServer.ExamServer.model.exam.Question;
import com.examServer.ExamServer.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {


    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long id);
    public  Set<Question> getQuestionOfQuiz(Quiz quiz);
    public void deleteQuest(Long quizid);
    public Question get(Long questionsId);

}
