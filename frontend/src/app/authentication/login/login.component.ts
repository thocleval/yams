import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
      model: any = {};
      loading = false;
      returnUrl: string;

      constructor(
            private route: ActivatedRoute,
            private router: Router,
            private authenticationService: AuthenticationService
  ) { }

      ngOnInit() {
            // reset login status
            this.authenticationService.logout();

            // get return url from route parameters or default to '/'
            this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
      }

      login() {
            this.loading = true;
            this.authenticationService.login(this.model.username, this.model.password)
                  .subscribe(
                      data => {
                            this.router.navigate([this.returnUrl]);
                      },
                      error => {
                            console.error(error);
                            this.loading = false;
                      });
      }
}
