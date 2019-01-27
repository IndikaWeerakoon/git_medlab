import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule, 
           MatButtonModule,
           MatInputModule, 
           MatRippleModule,
           MatFormFieldModule, 
           MatTooltipModule, 
           MatSelectModule, 
           MatCard,
           MatCardModule} from '@angular/material';

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
    MatCardModule
  ],
  exports:[
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatRippleModule,
    MatFormFieldModule,
    MatTooltipModule,
    MatSelectModule,
    MatCardModule
  ],
  declarations: []
})
export class MaterialModuleModule { }
