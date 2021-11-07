package com.examServer.ExamServer.service.impl;

import com.examServer.ExamServer.model.exam.Question;
import com.examServer.ExamServer.model.exam.Quiz;
import com.examServer.ExamServer.repo.QuestionRepository;
import com.examServer.ExamServer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {


        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long id) {
        return this.questionRepository.findById(id).get();
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuest(Long quizid) {
        Question question=new Question();
        question.setQuesId(quizid);
        this.questionRepository.delete(question);
    }

    @Override
    public Question get(Long questionsId) {
        return this.questionRepository.getOne(questionsId);
    }
}
