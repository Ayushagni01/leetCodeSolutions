import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {

  categories=[
    {
      cid:0,
      title:'',
    },
    
  ];

  quizData={
    title:'',
    description:'',
    maxMarks:'',
    numberOfQuestions:'',
    active:false,
    category:{
      cid:'',
    }
  }

  constructor(private _cat:CategoryService,private snack:MatSnackBar,private _quiz:QuizService) { }

  ngOnInit(): void {

    this._cat.categories().subscribe(
      
        (data:any)=>{
          //categories load here
          this.categories=data;
          console.log(this.categories);
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error','in Loading data ','error')
        

      }

    );

  }

  //adding dynamic data 
 


  //adding new quiz here
   addQuiz()
  {
 if(this.quizData.title.trim()=='' || this.quizData.title==null)
 {
    this.snack.open("Title Required",'',{
      duration:3000,
    });
    return;
 }
 //
 
 return this._quiz.addQuiz(this.quizData).subscribe(
  (data: any)=>{
    Swal.fire("Quiz","is added",'success');
   this.quizData={
      title:'',
      description:'',
      maxMarks:'',
      numberOfQuestions:'',
      active:false,
      category:{
        cid:'',
      },
    };
  },
  
  (error:any)=>{
  Swal.fire("Qy=uiz is empty ",'','error');
  }
  
   );
 //


 //call server for adding quiz

  

  }



}
