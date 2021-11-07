import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-question',
  templateUrl: './view-question.component.html',
  styleUrls: ['./view-question.component.css']
})
export class ViewQuestionComponent implements OnInit {

qId:any;
qTitle:any;
questions:any=[];


  constructor(
    private _route:ActivatedRoute
    ,private _question:QuestionService,
    private snak:MatSnackBar
  ) { }

  ngOnInit(): void {
  this.qId=  this._route.snapshot.params.qid;
  this.qTitle=  this._route.snapshot.params.title;
  this._question.getQuestionOfQuiz(this.qId).subscribe((data)=>{
    console.log(data);
    this.questions=data;
  
    },(error)=>{
      alert("Issue in get Question of Quiz");
    }


  );



  }

  //delete the question here
  deleteQuestion(qid:any)
  {
    Swal.fire({
      icon:'info',
      showCancelButton:true,
      confirmButtonText:'Delete',
      title:'Are you sure to delete',
    }).then((result)=>{

      if(result.isConfirmed)
      {
        this._question.deleteQuestion(qid).subscribe((data)=>{
        this.snak.open('Question deleted','',{
          duration:3000,
        });
        this.questions=this.questions.filter((q:any)=>q.quesId!=qid)
        },
        (error)=>{
          this.snak.open('Error in deleting the quiz','',{
            duration:3000,
          });
        });
      }

      
    });
  }


}
