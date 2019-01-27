import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { TestType } from '../classes/TestType';
import { TestData } from '../classes/test-details';
import { TestProfile } from '../classes/selectedTestProfile';
import { Test } from '../classes/Test';
import { SelectedTests } from '../classes/selectedTests';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  testSet :TestType[] = TestData;
  isLinear = false;
  private testProfiles:TestProfile[] = new Array();
  private customProfileName = "Custom";//name of the custom profile
  
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    console.log(this.testSet[0].testSet[1].name);
  }
 
  
  makeJSON(event,index,testProfile:TestType,test:Test = null){
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
      
   console.log(this.testProfiles);
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
  
}
