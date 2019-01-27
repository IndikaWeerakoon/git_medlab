import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../service/auth-servise.service';
import { User } from '../classes/user';
import { ValidateUser } from '../classes/validate-user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  private passwordField:string = "password";
  private iconPassword:string = "visibility";
  private status:ValidateUser;
  private user : User;
  private error;
  private login = this.fb.group({
    username : ['',Validators.required],
    password:['',Validators.required],
  })
  constructor(private fb:FormBuilder,private auth:AuthService, private router:Router) { }

  ngOnInit() {
  }
  onSubmit(){
    this.auth.loginUser(this.login.value).subscribe(data => this.status = data,
                                                      error=> this.error = error );
    localStorage.setItem('user',JSON.stringify(this.status));

    this.router.navigate(['']);

  }

  passwordFieldToggle(){
    this.iconPassword = (this.iconPassword==="visibility")?"visibility_off":"visibility";
    this.passwordField = (this.passwordField ==="password")?"text":"password";

  }

}
