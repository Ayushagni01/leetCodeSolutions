package com.examServer.ExamServer.repo;

import com.examServer.ExamServer.model.exam.Question;
import com.examServer.ExamServer.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);



}
