import { Error404Component } from './error404/error404.component';
import { Route } from '@angular/router';

export const ErrorsRoutes: Route[] = [
  {
    path: '*',
    component: Error404Component
  },
];
