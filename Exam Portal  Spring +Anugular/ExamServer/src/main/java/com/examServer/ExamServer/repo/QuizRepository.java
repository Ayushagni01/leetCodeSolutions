package com.examServer.ExamServer.repo;

import com.examServer.ExamServer.model.exam.Category;
import com.examServer.ExamServer.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {


    public List<Quiz> findBycategory(Category category);

    //return the active quiz only for the user specific data
    public List<Quiz> findByActive(Boolean b);
    //return the active quiz by category
    public List<Quiz> findByCategoryAndActive(Category category,Boolean b);

}
