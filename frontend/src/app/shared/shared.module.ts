import { TruncatePipe } from './truncate.pipe';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

/**
* Do not specify providers for modules that might be imported by a lazy loaded module.
*/

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
  ],
  declarations: [
    TruncatePipe,
  ],
  exports: [
    CommonModule,
    FormsModule,
    RouterModule,
    TruncatePipe,
  ]
})

export class SharedModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SharedModule,
      providers: []
    };
  }
}
