import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Customer } from '../classes/customer';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private UrlTpTest:string = "path/api/customer/";
  constructor(private http:HttpClient) { }

  public getCustomerByTelephone(tpNo:string):Observable<Customer>{
    return this.http.get<Customer>(this.UrlTpTest+tpNo).
                    catch(this.handleError);
    
  }
  private handleError(error: HttpErrorResponse) {
    return Observable.throw(error.message);
  }
}
