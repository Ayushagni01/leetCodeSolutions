import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    private UserService:UserService, private snack:MatSnackBar
  ) { }

  public user={
    username: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
    password: '',
  }

  ngOnInit(): void {
  }

  formSubmit()
  {
    if(this.user.username=='' || this.user.username==null)
    {
      //alert("user is required");
      this.snack.open("UserName is Required",'!',{
        duration:3000,
        verticalPosition:'top',
        horizontalPosition:'right',
      });
      return;
    }

    //validate 

    //addUser:userServices
   this.UserService.addUser(this.user).subscribe(
    (data:any)=>{
      //success
      console.log(data);
     // alert('success');
     Swal.fire('Success!','User is registered'+data.id,'success')
    },
    (error)=>{
      console.log(error);
     // alert("SomeThings went wrong-->Some error in processing request");
     this.snack.open("SomeThings went wrong!.Some error in processing request",'!',{
      duration:3000,
      verticalPosition:'top',
      horizontalPosition:'right',
    });
    }

   )

  }

  //this.user

}
