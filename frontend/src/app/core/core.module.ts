
import { RouterModule } from '@angular/router';
import { GithubComponent } from './github/github.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageHeaderComponent } from './page-header/page-header.component';
import { DummyComponent } from './dummy/dummy.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
  ],
  declarations: [SidebarComponent, GithubComponent, PageHeaderComponent, DummyComponent],
  exports: [SidebarComponent, GithubComponent, PageHeaderComponent],
})
export class CoreModule { }
