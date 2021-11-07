import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-load-quiz',
  templateUrl: './load-quiz.component.html',
  styleUrls: ['./load-quiz.component.css']
})
export class LoadQuizComponent implements OnInit {

  constructor(
    private _route:ActivatedRoute,
    private _quiz:QuizService
  ) { }

  catId:any;
    quizzes:any;
  ngOnInit(): void {
    
    this._route.params.subscribe((params)=>{
      this.catId=params.catId;
      if(this.catId==0)
    {
    this._quiz.getActiveQuizzes().subscribe((data)=>{
      console.log(data);
      this.quizzes=data;
     
     

    },(error)=>{
      Swal.fire("Issue in Loading Quiz",'','error');
    })
    }
    else{
    this._quiz.getActiveQuizzesByCategory(this.catId).subscribe((data)=>{
     this.quizzes=data; 
    },(error)=>{
      Swal.fire("Issue in Loading Quiz",'','error');
    });
    }
    });
    
    
  }

}
