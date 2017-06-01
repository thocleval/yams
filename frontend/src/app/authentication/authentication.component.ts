import { Router } from '@angular/router';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgbTabsetConfig, NgbModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss'],
  providers: [NgbTabsetConfig],
})
export class AuthenticationComponent implements OnInit {

  model = {
    email: 'valche.vc',
    password: '',
    repeatPassword: '',
    remember: true
  };

  newMessage = 'Test';

  @Output() onAddNewPost = new EventEmitter<String>();

  addPost() {
    this.onAddNewPost.next(this.newMessage);
    this.newMessage = '';
  }

  constructor(config: NgbTabsetConfig, private router: Router) {
    // customize default values of tabsets used by this component tree
    config.justify = 'center';
    config.type = 'pills';
  }

  ngOnInit() {
  }

  onLogin() {
    console.log(this.model);
    this.router.navigate(['artists']);
  }

  onRegister() {
    console.log(this.model);
    this.router.navigate(['artists']);
  }

}

