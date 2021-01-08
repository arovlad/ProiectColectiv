import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient, private router: Router) {
  }
  getData(id: number): Observable<any> {
    return this.http.get('http://localhost:8080/EmployeeAppFront_war/rest/profile/getByUser?userID=' + id);
  }
}
