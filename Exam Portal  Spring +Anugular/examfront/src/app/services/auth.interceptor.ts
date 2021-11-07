import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";

const TOKEN_HEADER='Authorization';

@Injectable()
export class AuthIterceptor implements HttpInterceptor
{
    constructor(private login:LoginService)
    {}
    
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
       
let authReq=req;
        //ad the jwt token
    
const token=this.login.getToken();
//add the toekn in request

if(token!=null)
{
    authReq=authReq.clone({setHeaders:{Authorization:`Bearer ${token}`},
});
}
return next.handle(authReq);

    }
    
}


export const authInterceptorProviders=[{
provide:HTTP_INTERCEPTORS,
useClass: AuthIterceptor,
multi:true,

},];