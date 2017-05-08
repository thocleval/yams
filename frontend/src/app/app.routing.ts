import { Routes } from '@angular/router';

import { AuthenticationRoutes } from './authentication/authentication.routing';
import { DashboardRoutes } from './dashboard/dashboard.routing';

import { AuthenticationComponent } from './authentication/authentication.component';

export const routes: Routes = [
  ...AuthenticationRoutes,
  ...DashboardRoutes,
  { path: '**', component: AuthenticationComponent }
];
