import { TestProfileReport } from "./TestProfile";
import { Test } from "./Test";

// Tis is user to retrieve repot for mlt
export interface TestReport{
    reportId:number;
    testProfile:TestProfileReport;
    testList:Test[]; 
}