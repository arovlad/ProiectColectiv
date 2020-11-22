import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = '';
  password = '';
  message = '';

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    // if (this.loginService.isLoggedIn()){
    //   this.router.navigate(['/dashboard', this.loginService.getRole()]);
    // }
    // else {
    //   this.router.navigate(['/login']);
    // }
  }

  Login(): void{
    this.loginService.login(this.username, this.password).subscribe(
      response => {
        const result = response.json();

        if (result > 0)
        {
          this.router.navigate(['/dashboard']);
        }
        else
          {
           alert('This user does not exist.');
          }
      },
      error => {
        alert('There was an error.');
      }
    );
  }
}
