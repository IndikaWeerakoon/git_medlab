import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth-servise.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGardService implements CanActivate {

  constructor(private route:Router, private auth:AuthService) { }

  public canActivate():boolean{ 
    if(!this.auth.isAuthenticated()){
      this.route.navigate(['login']);
      return false;
    }
    return true;
  }
}
