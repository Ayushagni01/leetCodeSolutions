package com.examServer.ExamServer.Controller;


import com.examServer.ExamServer.model.exam.Category;
import com.examServer.ExamServer.model.exam.Quiz;
import com.examServer.ExamServer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //step1 repose

    //step2 adding the quiz service

    @PostMapping("/")
    public ResponseEntity<Quiz> addCategory(@RequestBody Quiz quiz)
    {
         Quiz quiz1=this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    //step 3 update quiz
    @PutMapping("/")
    public  ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));

    }

    //step 4 get quiz for all

    @GetMapping("/")
    public ResponseEntity<?> getQuizes()
    {
        return ResponseEntity.ok(this.quizService.getQuizes());
    }

    //single quiz

    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid") Long qid)
    {
        return this.quizService.getQuiz(qid);

    }

    //steo 5 delete quiz

    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid)
    {
        this.quizService.deleteQuiz(qid);
    }

    //getting the
    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizOfCategory(@PathVariable("cid") Long cid)
    {
        Category category=new Category();
        category.setCid(cid);
        return this.quizService.getQuizOfCategory(category);
    }


    //get active quuizzes
    @GetMapping("/active")
    public List<Quiz>  getActiveQuizes()
    {
        return this.quizService.getActiveQuizzes();
    }

    @GetMapping("/category/active/{cid}")
    public List<Quiz>  getActiveQuizesOfCategory(@PathVariable("cid") Long cid)
    {
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }



}
