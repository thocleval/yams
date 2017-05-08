import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AuthenticationComponent } from './authentication.component';

import { NgbTabsetConfig, NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    NgbModule
  ],
  declarations: [AuthenticationComponent],
  exports: [AuthenticationComponent]
})
export class AuthenticationModule {}

