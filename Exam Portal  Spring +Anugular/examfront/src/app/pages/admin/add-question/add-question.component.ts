import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { Editor } from 'ngx-editor';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {
  public Editor = ClassicEditor;
  //editor: Editor = new Editor;
 

qId:any;
qTitle:any;
question:any={
  quiz:{

  },
  content:'',
  option1:'',
  option3:'',
  option4:'',
  answer:'',
};

  constructor(private _route:ActivatedRoute, private _question:QuestionService) { }

  ngOnInit(): void {
    this.qId=this._route.snapshot.params.qid;
    this.question.quiz['qid']=this.qId;
    this.qTitle=this._route.snapshot.params.title;

    

  }

  formSubmit()
  {
  if(this.question.content.trim()=='' || this.question.content==null || this.question.answer.trim()=='' || this.question.answer==null)
  {
    return;
  }
  if(this.question.option1.trim()=='' || this.question.option1==null || this.question.option2.trim()=='' || this.question.option2==null)
  {
    return;
  }
  //form submit quiz here
this._question.addQuestion(this.question).subscribe((data)=>{

Swal.fire("Success","Added",'success');
this.question.content='';
this.question.option1='';
this.question.option2='';
this.question.option3='';
this.question.option4='';
this.question.answer='';

},(error)=>{
  Swal.fire("Error","Not Added",'error');
});

  }

}
