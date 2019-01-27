import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ValidateUser } from '../classes/validate-user';
import { User } from '../classes/user';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url:string = '/path/api/user/login';
  private user:ValidateUser;
  constructor(private http :HttpClient) { }

  public loginUser(userInfo:User):Observable<ValidateUser>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token',
        'Access-Control-Allow-Origin':"*",
        
      })
    };
    return this.http.post<ValidateUser>(this.url,userInfo,httpOptions)
              .catch(this.errorHandler);

  }

  private errorHandler(error:HttpErrorResponse){
      return Observable.throw(error.message);
  }

  public isAuthenticated():boolean{
let id = localStorage.getItem('user')
    console.log(id);
    if(!id){
      console.log("not work");
      return false;
    }else {
      this.user = JSON.parse(localStorage.getItem('user'));
      if(!this.user.status){
        return false;
      }
      return true;
    }
    
  }
  public getUserName(){
    let user = JSON.parse(localStorage.getItem('user'));
    return user.username;
  }

}
