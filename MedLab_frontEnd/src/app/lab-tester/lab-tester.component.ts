import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth-servise.service';
import { Router } from '@angular/router';
import { ReportSubmitService } from '../service/report-submit.service';
import { TestReport } from '../classes/TestReport';
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';

@Component({
  selector: 'app-lab-tester',
  templateUrl: './lab-tester.component.html',
  styleUrls: ['./lab-tester.component.scss']
})
export class LabTesterComponent implements OnInit {
  private testData = [
    {Test_name : "White Blood Test(WBC) count", unit:"billion cells/L"},
    {Test_name : "Red Blood Cell (RBC) count",  unit : "trillion cells/L"},
    {Test_name : "Platelets count",  unit:"billion/L"},
    {Test_name : "Hemoblibin" ,  unit:"grams/dL"},
    {Test_name : "Hemotocrite",  unit: "%percent"},
  ];

  private userName:string;
  private toggle:boolean;//dummy variable for testing purposes
  private testingReport:TestReport;
  private error:string;
  private speciman:FormGroup;
  private testDataForm:FormGroup;
  private items: FormArray;

  constructor(private auth:AuthService, private router:Router, private report: ReportSubmitService,
                private fb:FormBuilder) { }

  ngOnInit() {
    this.speciman = this.fb.group({
      specimanId:[''],
    });

    this.testDataForm = this.fb.group({
      reportId:[''],
      profileId:[''],
      testResultList:this.fb.array([]),
    })

    this.userName = this.auth.getUserName();
  }
  addFrom(){
    this.items = this.testDataForm.get('testResultList') as FormArray;
    this.items.push(this.getFormTest());
  }
  getTitle(){
    return 'Laboratory Management System';
  }
  signOut(){
    localStorage.removeItem('user');
    this.router.navigate(['login']);

  }
  searchFromSpecimen(){
    this.report.getReport(this.speciman.value.specimanId)
              .subscribe(
                (data:TestReport)=>{//add form list items
                  this.testingReport = data;
                  this.error = null;
                  
                  this.testingReport.testList.forEach((test,index)=>{
                    this.addFrom();
                  })
                },
                (error)=>{
                  this.error = error;
                  this.testingReport=null;
                }
              );
    
  }

  getFormTest():FormGroup{
    return this.fb.group({
      testId:[''],
      testValue:[''],
    })
  }

  onSubmit(){
    console.log(JSON.stringify(this.testDataForm.value));
  }
  trackByTestId(index:number,test:any){
    return test.testId;
  }
}
