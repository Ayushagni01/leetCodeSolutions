import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit {

  constructor(private route:ActivatedRoute,private _quiz:QuizService,private _cat:CategoryService,private _router:Router) { }

  qId= -1;
  quiz:any;
  categories:any;

  ngOnInit(): void {

  this.qId=  this.route.snapshot.params.qid;
   this._quiz.getQuiz(this.qId).subscribe(
    (data:any)=>{
      this.quiz=data;
      console.log(this.quiz);
    },
    (error)=>{
      Swal.fire('Error','in getting quiz data','error');
    }

   );
    // loading catgory data here
    this._cat.categories().subscribe(
      (data)=>{
        this.categories=data;
      },(error)=>{
        alert("Error in loading data")
      }
    )



  }
  //update quiz here
  public updateQuiz()
  {
   //validation with here
this._quiz.updateQuiz(this.quiz).subscribe(
(data:any)=>{
  Swal.fire("Data Updated ","SuccessFUlly",'success').then((e)=>{
    this._router.navigate(['/admin/quizzes']);
  });
},(error)=>{
  Swal.fire("Error ","Issue in Update ",'error');
});

  }


}
