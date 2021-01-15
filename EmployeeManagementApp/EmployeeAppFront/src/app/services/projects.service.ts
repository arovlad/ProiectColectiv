import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {

  constructor(private http: HttpClient) { }

  get(id: string): Observable<any> {
    return this.http.get('http://localhost:8080/EmployeeAppFront_war/rest/project/find?id=' + id);
  }

  save(customer: string, description: string, duration: string, industry: string, title: string): Observable<any> {
    const info = {customer, description, duration, industry, title};
    return this.http.post('http://localhost:8080/EmployeeAppFront_war/rest/project/save', info);
  }

  delete(id: string): Observable<any> {
    return this.http.delete('http://localhost:8080/EmployeeAppFront_war/rest/project/delete?id=' + id);
  }

  update(id: string, customer: string, description: string, duration: string, industry: string, name: string): Observable<any> {
    const info = {customer, description, duration, industry, name};
    return this.http.post('http://localhost:8080/EmployeeAppFront_war/rest/project/update?id=' + id, info);
  }
}
