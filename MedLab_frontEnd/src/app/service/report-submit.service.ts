import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { TestReport } from '../classes/TestReport';

@Injectable({
  providedIn: 'root'
})
export class ReportSubmitService {
  private reportURL:string = 'path/api/form/report/';
  constructor(private http:HttpClient) { }

  public getReport(specimanId:string):Observable<TestReport>{
    return this.http.get<TestReport>(this.reportURL + specimanId).catch(this.errorHandler); 
  }

  private errorHandler(error:HttpErrorResponse){
    return Observable.throw(error.message);
  }
}
