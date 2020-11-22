import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = '/rest/user/login';

  constructor(private httpClient: HttpClient, private router: Router) { }

  login(usernameOrEmail: string, password: string): Observable<any>
  {
    const loginDetails = JSON.stringify([usernameOrEmail, password]);
    return this.httpClient.post(this.baseUrl, loginDetails);
  }
}
