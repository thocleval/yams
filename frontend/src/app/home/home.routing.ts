import { HomeComponent } from './home.component';
import { Route } from '@angular/router';

export const HomeRoutes: Route[] = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: '',
    component: HomeComponent
  }
];
