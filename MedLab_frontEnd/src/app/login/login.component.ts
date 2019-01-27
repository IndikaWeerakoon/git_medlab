import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms'; 
import { AuthService } from '../service/auth-servise.service';
import { User } from '../classes/user';
import { ValidateUser } from '../classes/validate-user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  private passwordField:string = "password";
  private iconPassword:string = "visibility";
  private status:ValidateUser;
  private user :User;
  private login = this.fb.group({
    username : ['',Validators.required],
    password:['',Validators.required],
  })
  constructor(private fb:FormBuilder,private auth:AuthService) { }

  ngOnInit() {
  }
  onSubmit(){
    this.status = {status:true,type:"admin"};
    this.auth.loginUser(this.login.value).subscribe(data=> this.status = data);
    localStorage.setItem('user',JSON.stringify(this.status));
    console.log(this.status.status);
  }

  passwordFieldToggle(){
    this.iconPassword = (this.iconPassword==="visibility")?"visibility_off":"visibility";
    this.passwordField = (this.passwordField ==="password")?"text":"password";
  }

}
