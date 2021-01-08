import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient, private router: Router) { }

  Login(username: string, password: string): Observable<any> {
    const loginDetails = {usernameOrEmail: username, password: password};
    return this.http.post('http://localhost:8080/EmployeeAppFront_war/rest/user/login', loginDetails);
  }
}
