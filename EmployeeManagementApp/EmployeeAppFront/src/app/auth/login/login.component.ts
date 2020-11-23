import { Component, OnInit } from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {Router} from '@angular/router';
import { LoginService } from '../../services/login.service';

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
        const result = response.json();
      },
      error => {
        alert('This user does not exist');
      }
    );
  }
}
