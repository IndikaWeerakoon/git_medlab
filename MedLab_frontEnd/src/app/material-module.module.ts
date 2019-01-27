import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule, 
           MatButtonModule,
           MatInputModule, 
           MatRippleModule,
           MatFormFieldModule, 
           MatTooltipModule, 
           MatSelectModule } from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatRippleModule,
    MatFormFieldModule,
    MatTooltipModule,
    MatSelectModule,
  ],
  exports:[
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatRippleModule,
    MatFormFieldModule,
    MatTooltipModule,
    MatSelectModule,
  ],
  declarations: []
})
export class MaterialModuleModule { }
