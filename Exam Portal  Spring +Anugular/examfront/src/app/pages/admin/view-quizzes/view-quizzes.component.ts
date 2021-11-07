import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quizzes',
  templateUrl: './view-quizzes.component.html',
  styleUrls: ['./view-quizzes.component.css']
})
export class ViewQuizzesComponent implements OnInit {

  quizzes=[
  {
    qid:0,
    title:'',
    description:'',
    maxMarks:'',
    numberOfQuestions:'',
    active:'',
    category:{
      title:'',
      description:'',
    }

  },
  

  ];

  constructor(private _quiz:QuizService) { }

  ngOnInit(): void {
    this._quiz.quizzes().subscribe(
      (data:any)=>{
        this.quizzes=data;
        console.log(this.quizzes);
      },
      (error)=>{
        console.error(error);
        Swal.fire('Error !',"Error in Loadind data",'error');
        
      },


    );

  }

  deleteQuiz(qid:any)
  {
    Swal.fire({
      icon:'info',
        title:"are you Sure ",
        confirmButtonText:"Delete",
        showCancelButton:true
    }).then((result)=>{
      if(result.isConfirmed)
      {

        this._quiz.deleteQuiz(qid).subscribe(
          (data)=>{
          this.quizzes=  this.quizzes.filter((quiz)=>quiz.qid!=qid);
            Swal.fire('Success !',"Quiz Deleted",'success');
    
          },
          (error)=>{
            Swal.fire('Error !',"Error in deleting the quiz",'error');
          }
        );


      }

    });

   
  }


  deleteQuiz1(qid:any){
     //calling api to delete this service
     
  }

}
