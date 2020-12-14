import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {

  constructor(private http: HttpClient) { }

  get(): Observable<any> {
    const info = 'placeholder';
    return this.http.post('placeholder', info);
  }
}
