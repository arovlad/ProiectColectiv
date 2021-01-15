import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegionsService {
  constructor(private http: HttpClient) {}
  save(name: string): Observable<any>{
    const info = {name};
    return this.http.post('http://localhost:8080/EmployeeAppFront_war/rest/region/save', info);

  }
  delete(id: number): Observable <any>{
    return this.http.delete('http://localhost:8080/EmployeeAppFront_war/rest/region/delete?id=' + id);
  }
}
