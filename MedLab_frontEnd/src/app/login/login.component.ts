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
    if(this.status.user_type == 'RECEPTION'){
        this.error = false;
        this.router.navigate(['']);
    }
    else if(this.status.user_type == 'MLT'){
      this.error = false;
      this.router.navigate(['mlt']);
    }else{
      this.error = true;
    }

    

  }

  passwordFieldToggle(){
    this.iconPassword = (this.iconPassword==="visibility")?"visibility_off":"visibility";
    this.passwordField = (this.passwordField ==="password")?"text":"password";

  }

}
