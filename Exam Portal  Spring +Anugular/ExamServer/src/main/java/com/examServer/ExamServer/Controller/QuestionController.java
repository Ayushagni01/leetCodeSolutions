package com.examServer.ExamServer.Controller;

import com.examServer.ExamServer.model.exam.Question;
import com.examServer.ExamServer.model.exam.Quiz;
import com.examServer.ExamServer.service.QuestionService;
import com.examServer.ExamServer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //step 1 above autowired


    //step 2 add quiz

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {

        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //step 2 update
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //step 3 getting quiz of question

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid)
    {

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List<Question> list=new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
        {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
        }
        list.forEach((q)->{
            q.setAnswer(" ");
        });
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
        
        
        /*
        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);
        */
    }

    //get for single queston
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId)
    {
        return this.questionService.getQuestion(quesId);
    }

    //delete question

    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId)
    {
        this.questionService.deleteQuest(quesId);
    }


    //getting all question of the quiz

    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") Long qid)
    {


        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);

    }

    //checking the answer of the question
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
    {
        int correctAnswer=0;
        double marksGot=0;
        int attempted=0;
       for(Question q:questions)
       {

            Question question = this.questionService.get(q.getQuesId());
            if(question.getAnswer().equals(q.getGivenAnswer()))
            {
                //
                correctAnswer++;
                Double marksSingle=  Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksGot+=marksSingle;
            }
           if(q.getGivenAnswer()!=null || !q.getGivenAnswer().equals(""))
           {
               attempted++;
           }
        }

       Map<String,Object> map=Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attempted",attempted);



        return ResponseEntity.ok(map);
    }

}
