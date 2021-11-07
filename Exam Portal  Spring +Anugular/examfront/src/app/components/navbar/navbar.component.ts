import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn:boolean=false;
  user:any=null;

  marksGot=0;
  correctAnswers=0;
  attempted=0;



  constructor(public login:LoginService) { }

  ngOnInit(): void {
    this.isLoggedIn=this.login.isLoogin();
    this.user=this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe((data)=>{
      this.isLoggedIn=this.login.isLoogin();
      this.user=this.login.getUser();
    }); //    alert("this.isLoggedIN is"+this.isLoggedIn);
    
  }


  public logout(){

    this.login.logout();
    window.location.reload();
    //this.login.loginStatusSubject.next(false);
  
  }

}
