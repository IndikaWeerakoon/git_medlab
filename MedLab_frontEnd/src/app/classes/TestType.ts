//this interface is observe test profile details that comefrome the request
import { Test } from "./Test";
export interface TestType{
    testProfileId: number;
    testProfileName: string;
    testSet:Test[];
}

