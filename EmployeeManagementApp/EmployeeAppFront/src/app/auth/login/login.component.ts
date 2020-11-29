import { Component, OnInit } from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {Router} from '@angular/router';
import { LoginService } from '../../services/login.service';
import { ILoginInformation } from './loginInformation';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  username = '';
  password = '';
  message = '';

  constructor(private loginService: LoginService, private router: Router) {
  }

  // constructor() {
  // }

  ngOnInit(): void {
  }
 Login(): void {
    this.loginService.Login(this.username, this.password).subscribe(
      response => {
        const loginInfo: ILoginInformation = response.response;
        if (loginInfo.logInResult === 3){
          if (loginInfo.userRoleId === 1){ // employee
            this.router.navigate(['/dashboard/projects']);
          }
          if (loginInfo.userRoleId === 2){ // admin
            this.router.navigate(['/dashboard/admin']);
          }
          if (loginInfo.userRoleId === 3){ // supervisor
            this.router.navigate(['/dashboard/users']);
          }
        }
      },
      error => {
        alert('There was an error');
      }
    );
  }
}
