import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }
  get(): Observable<any>{
    return this.http.get('http://localhost:8080/EmployeeAppFront_war/rest/profile/all');

  }
}
