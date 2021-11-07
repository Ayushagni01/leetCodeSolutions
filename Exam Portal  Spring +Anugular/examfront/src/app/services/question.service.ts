import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http:HttpClient) { }


  //get all questions
  public  getQuestionOfQuiz(qid:any){

    return this.http.get(`${baseUrl}/question/quiz/all/${qid}`);
  }  
//add question in databaswe

public addQuestion(question:any)
{
  return this.http.post(`${baseUrl}/question/`,question);
}

public deleteQuestion(questionId:any)
{
  return this.http.delete(`${baseUrl}/question/${questionId}`);

}

//get question of quiz id here
public  getQuestionOfQuizForTest(qid:any){

  return this.http.get(`${baseUrl}/question/quiz/${qid}`);
}  

//evaluatiing quizz
public evalQuiz(questions:any)
{
return this.http.post(`${baseUrl}/question/eval-quiz`,questions);
}

}
