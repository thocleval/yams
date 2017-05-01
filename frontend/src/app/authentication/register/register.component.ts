import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

export class RegisterComponent {
  model: any = {};
  loading = false;

  constructor(
    private router: Router,
    private userService: UserService
  ) { }

  register() {
    this.loading = true;
    this.userService.create(this.model)
      .subscribe(
      data => {
        // set success message and pass true paramater to persist the message after redirecting to the login page
        console.log('Registration successful', true);
        this.router.navigate(['/login']);
      },
      error => {
        console.error(error);
        this.loading = false;
      });
  }
}
