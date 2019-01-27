import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from './auth-servise.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGardService implements CanActivate {

  constructor(private route:Router, private auth:AuthService) { }

  public canActivate(route: ActivatedRouteSnapshot):boolean{
    let expectedRole = route.data.expectedRole;
    
    let user = JSON.parse(localStorage.getItem('user'));
    if(!this.auth.isAuthenticated() || user.user_type != expectedRole){
      this.route.navigate(['login']);
      return false;
    }else{
      
      return true;
    }
    
  }
}
