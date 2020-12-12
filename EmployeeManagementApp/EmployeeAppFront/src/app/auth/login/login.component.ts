import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { LoginService } from '../../services/login.service';
import { ILoginInformation} from './loginInformation';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  username = '';
  password = '';
  message1 = 0;
  message2 = '';
  message3 = 0;
  message4 = 0;
  message5 = 0;

  constructor(private loginService: LoginService, private router: Router) {
  }

  ngOnInit(): void {
  }

  Login(): void {
    if (this.password === ''){
      this.message5 = 1;
    }

    else {
      this.message5 = 0;
    }

    if (this.username === ''){
     this.message4 = 1;
    }

    else{
     this.message4 = 0;
    }

    this.loginService.Login(this.username, this.password).subscribe(
      response => {
        this.message1 = 0;
        this.message3 = 0;
        this.message2 = '';
        const loginInfo: ILoginInformation = response.response;

        if (loginInfo.logInResult === 1 ){
          this.message1 = 1;
          this.message2 = loginInfo.nrRemainigAttempts.toString();
        }

        else if (loginInfo.logInResult === 2){
        this.message3 = 1;
        }

        else {
            localStorage.setItem('role', String(loginInfo.logInResult));
            // localStorage.setItem('id', String(loginInfo.userId));

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
