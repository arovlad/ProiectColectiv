import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TechnologyareaService {

  constructor(private http: HttpClient) {}
  save(newName: string): Observable <any>{
    const info = 'placeholder';
    return this.http.post('placeholder', info);
  }
  delete(name: string): Observable <any>{
    const info = 'placeholder';
    return this.http.post('placeholder', info);
  }
}
