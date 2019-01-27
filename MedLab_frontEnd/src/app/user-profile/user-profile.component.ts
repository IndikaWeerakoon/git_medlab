import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder, FormControl } from '@angular/forms';
import { TestType } from '../classes/TestType';
import { TestData } from '../classes/test-details';
import { TestProfile } from '../classes/selectedTestProfile';
import { Test } from '../classes/Test';
import { SelectedTests } from '../classes/selectedTests';
import { CustomerService } from '../service/customer.service';
import { Customer } from '../classes/customer';
import { TestService } from '../service/test.service';
import { RequestData } from '../classes/RequestData';
import { Receipt } from '../classes/receipt';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  private testSet :TestType[];//Store returened test data
  private isLinear = false;
  private testProfiles:TestProfile[] = new Array();//Store selected test profile and test data
  private customProfileName = "Custom";//name of the custom profile
  private customerDetailForm:FormGroup;
  private specimenIds:FormGroup;
  private existingCustomerData:Customer = new Customer();
  private SubTotal:number = 1000.0;//total price of customr bill
  private locations:Location[];
  private receipt:Receipt;
  private requestData:RequestData;
  private finalSubmitError;

  constructor(private _formBuilder: FormBuilder, private customer:CustomerService, private test:TestService ,private router:Router) { }

  ngOnInit() {
    this.customerDetailForm = this._formBuilder.group({
      customerId:[''],
      tpNo: ['', Validators.required],
      name: ['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      dateOfBirth:['',Validators.required],
      location:[,Validators.required],
      gender:['',Validators.required],
    
    });

    this.specimenIds = this._formBuilder.group({
        specimenId:[''],
    })
    

    this.test.getTestProfile().subscribe((data:TestType[])=>{this.testSet = data;},
                                          error=>{console.error(error);});//should handle error as well
    
    this.test.getLocation().subscribe((data:Location[])=>{this.locations = data;})
    
    this.test.getReciept().subscribe((data:Receipt) => {
      this.receipt = data;
    })
  }

  //+=====================================================
  //this method send totaly collected data as post request
  //+=====================================================
  sendBigData(){
      this.requestData = new RequestData();
      this.requestData.selectedTestprof = this.testProfiles;
      this.requestData.customerDetails = this.customerDetailForm.value;
      this.requestData.SpecimenId = this.specimenIds.value.specimenId;
      this.requestData.recieptId = this.receipt.receiptId;
      this.requestData.totalTest = this.SubTotal;

      this.test.saveCompleteRoport(this.requestData)
                .subscribe((data)=>{  this.finalSubmitError = null;
                                      this.router.navigate(['dashboard']);
                                    },
                            (error)=>{this.finalSubmitError = error;})
      
      console.log(JSON.stringify(this.requestData));
  }

  //+=====================================================
  //tp should show error massege or any status to the user
  //+=====================================================
  onTpSubmit(){
    // console.log(this.customerDetailForm.value.dateOfBirth);
    this.customer.getCustomerByTelephone(this.customerDetailForm.value.tpNo).subscribe(
      (data:Customer )=> {
                          this.existingCustomerData = new Customer();
                          this.existingCustomerData = data;
                          this.existingCustomerData.gender = this.existingCustomerData.gender.toLocaleLowerCase();
                          console.error(this.existingCustomerData);},
      (error)=>{console.error("ERROR FOUNE :  "+error); 
                  this.existingCustomerData = new Customer();
                }
    )
  }
  /*+==========================================================
      this dummy method for testing some outputs
    +========================================================== */
  onSubmit(){
    console.log(this.specimenIds.value);
    
  }
  /*+==========================================================
      Make JSON file for test selection
    +========================================================== */
  private makeJSON(event,index,testProfile:TestType,test:Test = null){
    console.log(this.arrayElementFinder(testProfile.testProfileName));
    let testProfileId = this.arrayElementFinder(testProfile.testProfileName);
    if(event.checked){//if checked
      if(testProfileId == -1){//divide from condition
        let testProf:TestProfile = new TestProfile();
        testProf.profileId = testProfile.testProfileId;
        testProf.profileName = testProfile.testProfileName;
      
      if(testProfile.testProfileName == this.customProfileName){//add new custom prifile test when on element "Custom " in the array
        let testSelected :SelectedTests = new SelectedTests();
        testSelected.testId = test.testId;
        testSelected.testName = test.name;
        testSelected.price = test.price;
        testProf.tests = new Array();
        testProf.tests.push(testSelected);
        
       
      }
      this.testProfiles.splice(index,0,testProf);
      }else{//element already in the array
        if(testProfile.testProfileName == this.customProfileName){
          let selectedTest:number = this.arrayTest(this.testProfiles[testProfileId].tests,test.testId);
          if(selectedTest == -1){
            let testSelected :SelectedTests = new SelectedTests();
            testSelected.testId = test.testId;
            testSelected.testName = test.name;
            testSelected.price = test.price;
            this.testProfiles[testProfileId].tests.push(testSelected);
          }
        }
      }
      
    }else{//when unchecked the element
      if(testProfile.testProfileName != this.customProfileName){
        this.testProfiles.splice(testProfileId ,1);
      }else{//remove element from "Custom test"
        let selectedTestId = this.arrayTest(this.testProfiles[testProfileId].tests,test.testId);
        this.testProfiles[testProfileId].tests.splice(selectedTestId ,1);
        if(this.testProfiles[testProfileId].tests.length == 0){
          this.testProfiles.splice(testProfileId ,1);
        }
      }
      
    }// hooray it works fine...!
    console.log( JSON.stringify(this.testProfiles));
  }
  private arrayElementFinder(profileName:string):number{//select element from testprofiles
    let selectedIndex:number = -1;
    this.testProfiles.forEach((value,index)=>{
        if(value.profileName == profileName){
          selectedIndex = index;
        }
    });
    return selectedIndex;
  }
  private arrayTest(array:Array<SelectedTests>,elementId:number):number{
    let selectedIndex:number = -1 
    array.forEach((element,index)=>{
        if(element.testId == elementId){
          selectedIndex  = index;
        }
    })
    return selectedIndex;
  }

  private testProfilePrice(testProfId:number):number{
    let total:number = 0 ;
    this.testSet.forEach((value,index)=>{
      
      if(testProfId == value.testProfileId && value.testProfileName != this.customProfileName){
        value.testSet.forEach(value=>{
          total += value.price;
        });
      }
    });
    
    return total;
  }

  private  customTestPrice():number{
    let total:number = 0 ;
    this.testProfiles.forEach(value => {
      if(value.profileName == this.customProfileName){
          value.tests.forEach(val=>{
            total += val.price;
          });
      }
    })
    
    return total;
  }
  private isCustomTest(nameProf):boolean{
     return (nameProf==this.customProfileName)?false:true;
  }
}
