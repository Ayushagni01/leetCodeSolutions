import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http:HttpClient) { }

public quizzes()
{
return this.http.get(`${baseUrl}/quiz/`);


}

 addQuiz(quiz:any)
{
  return this.http.post(`${baseUrl}/quiz/`,quiz);
}

public deleteQuiz(qid:any)
{
return this.http.delete(`${baseUrl}/quiz/${qid}`);

}

// get the single quiz
public getQuiz(qid:any)
{
  return this.http.get(`${baseUrl}/quiz/${qid}`);
}

//for updateing quiz 

public updateQuiz(quiz:any){
return   this.http.put(`${baseUrl}/quiz/`,quiz)
}

//get quiz service by categroy
public getQuizzesOfCategory(cid:any)
{
  return this.http.get(`${baseUrl}/quiz/category/${cid}`);
}

//getting the data of active user
public getActiveQuizzes()
{
  return this.http.get(`${baseUrl}/quiz/active`);
}

//get the active quiz by caegory
public getActiveQuizzesByCategory(cid:any)
{
  return this.http.get(`${baseUrl}/quiz/category/active/${cid}`);
}



}
