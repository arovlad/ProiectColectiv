import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SkillService {

  constructor(private http: HttpClient) { }

  getAllTechAreas(): Observable<any>{
      return this.http.get('http://localhost:8080/EmployeeAppFront_war/rest/skills/technologyareas');

  }
  saveSkill(skillName: string, techArea: string): Observable<any>{
    const skillDetails = {skillName: skillName, technologyArea: techArea};
    return this.http.post('http://localhost:8080/EmployeeAppFront_war/rest/skills/save',skillDetails);

  }
}
