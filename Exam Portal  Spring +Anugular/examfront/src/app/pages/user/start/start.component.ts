import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
export class StartComponent implements OnInit {

  constructor(private locationSt:LocationStrategy,
    private _route:ActivatedRoute,
    private question:QuestionService
    ) { }

  qid:any;
  questions:any;
  correctAnswer=0;
  marksGot=0;
  attempted=0;
  isSubmit=false;
  timer:any;
  ngOnInit(): void {
    this.preventBackButton();
    this.qid=this._route.snapshot.params.qid;
    this.loadQuestion();
    
  
  }
  loadQuestion() {
    this.question.getQuestionOfQuizForTest(this.qid).subscribe((data)=>{
     this.questions=data;
     this.timer=this.questions.length*2*60;
     console.log("this timer "+this.timer);
     console.log(this.questions);
     this.questions.forEach((q:any)=>{
      q['givenAnswer']='';
     });
     this.startTimer();



    },(error)=>{
      Swal.fire('Error in loading question','','error');
    });


  }

  preventBackButton()
  {
    history.pushState(null,location.href,null);
    this.locationSt.onPopState(()=>{
      history.pushState
      history.pushState(null,location.href,null);
    });
  }

  public submitQuiz()
  {
    Swal.fire({
      title: 'Do you want to Submit the Quiz?',
      showCancelButton: true,
      confirmButtonText: `Submit`,
      icon:'info'
    }).then((e)=>{
      if(e.isConfirmed)
      {
       this.evalQuiz();

      }
    });

  }

//start timer
public startTimer()
{
let t=  window.setInterval(()=>{
    if(this.timer<=0)
    {
      this.evalQuiz();
      clearInterval(t);
    }else{
      this.timer--;
    }
  },1000)
}

public getFormattedTime()
{
  let mm=Math.floor(this.timer/60);
  let ss=Math.floor(this.timer-mm*60)
  return `${mm} Min: ${ss} Sec` ;
}

  public evalQuiz()
  {
    //calling request to server to check question

    this.question.evalQuiz(this.questions).subscribe((data:any)=>{
      this.marksGot=parseFloat(Number(data.marksGot).toFixed(2));
      this.correctAnswer=data.correctAnswer;
      this.attempted=data.attempted;
      this.isSubmit=true;
    },(error)=>{
      Swal.fire('Error in evaluating question','','error');
    });

     //calculation
     /*
     this.isSubmit=true;
     this.questions.forEach((q:any)=>{

       if(q.givenAnswer==q.answer)
       {
         this.correctAnswer++;
         //find the quest
       let marksSingle=  this.questions[0].quiz.maxMarks/this.questions.length;
         this.marksGot+=marksSingle;


       }
       if(q.givenAnswer.trim()!='')
       {
         this.attempted++;
       }

     
       


     });

     console.log("Correct Answer"+this.correctAnswer);
     console.log("Marks Got"+this.marksGot);
     console.log("quiz attempted is "+this.attempted);
     */
  }

  public printPage()
  {
    window.print();
  }

}
