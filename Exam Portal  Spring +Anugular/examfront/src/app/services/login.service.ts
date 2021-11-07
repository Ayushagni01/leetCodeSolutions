import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject =new Subject<boolean>();

  constructor(private http:HttpClient) { }

  //generate Token here

  public generateToken(loginData:any)
  {
    return this.http.post(`${baseUrl}/generate-token`,loginData);

  }

  //login user in local strotrage
  public loginUser(token:any)
  { 
    localStorage.setItem('token',token);
    //this.loginStatusSubject.next(true);
    return true;

  }

  //checked whether is login or not
  //using is login

  public isLoogin()
  {
    let tokenStr=localStorage.getItem("token")
    if(tokenStr==undefined || tokenStr== '' || tokenStr==null)
    {
      return false;
    }
    else{
      return true;
    }
  }

  //logout rewmove token from local storage
  public logout(){
  localStorage.removeItem("token");
  localStorage.removeItem('user');
    return true;

  }

  //taking token  from local
  //get token 
  public getToken()
  {
    return localStorage.getItem('token');

  }

  //set user details
  public setUser(user:any)
  {
    localStorage.setItem('user',JSON.stringify(user));
  }

  public getUser()
  {
    let userStr=localStorage.getItem("user");
    if(userStr!=null)
    {
      return JSON.parse(userStr);
    }else{
      this.logout();
      return null;
    }
  }
//getting user role

public getUserRole()
{
let user=this.getUser();
return user.authorities[0].authority;
}

//current user details which is login in 
public getCurrentUser()
{
  return this.http.get(`${baseUrl}/current-user`);
}

//creating event which eell 

}
